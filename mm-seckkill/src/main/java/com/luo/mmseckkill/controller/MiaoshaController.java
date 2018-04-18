package com.luo.mmseckkill.controller;

import com.google.common.collect.Maps;
import com.luo.mmseckkill.access.AccessLimit;
import com.luo.mmseckkill.model.MiaoshaOrder;
import com.luo.mmseckkill.model.MiaoshaUser;
import com.luo.mmseckkill.rabbitmq.MiaoshaMessage;
import com.luo.mmseckkill.rabbitmq.MqSender;
import com.luo.mmseckkill.redis.RedisService;
import com.luo.mmseckkill.redis.key.GoodsKey;
import com.luo.mmseckkill.result.CodeMsg;
import com.luo.mmseckkill.result.Result;
import com.luo.mmseckkill.service.GoodsService;
import com.luo.mmseckkill.service.MiaoshaService;
import com.luo.mmseckkill.service.MiaoshaUserService;
import com.luo.mmseckkill.service.OrderService;
import com.luo.mmseckkill.vo.GoodsVo;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/miaosha")
public class MiaoshaController implements InitializingBean {

    @Autowired
    MiaoshaUserService userService;

    @Autowired
    RedisService redisService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;

    @Autowired
    MiaoshaService miaoshaService;

    @Autowired
    MqSender mqSender;

    private Map<Long, Boolean> localOverMap = Maps.newConcurrentMap();


    /**
     * 系统初始化
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        List<GoodsVo> goodsList = goodsService.listGoodsVo();
        if(goodsList == null) {
            return;
        }
        for(GoodsVo goods : goodsList) {
            redisService.set(GoodsKey.getMiaoshaGoodsStock, ""+goods.getId(), goods.getStockCount());
            localOverMap.put(goods.getId(), false);
        }
    }

    @RequestMapping(value="/{path}/do_miaosha", method=RequestMethod.POST)
    @ResponseBody
    public Result<Integer> miaosha(Model model, MiaoshaUser user, @RequestParam("goodsId")long goodsId,
                                   @PathVariable("path") String path){
        model.addAttribute("user", user);
        if(user == null) {
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        //验证path
        boolean check = miaoshaService.checkPath(user, goodsId, path);
        if(!check){
            return Result.error(CodeMsg.REQUEST_ILLEGAL);
        }
        //内存标记，减少redis访问
        boolean over = localOverMap.get(goodsId);
        if(over) {
            return Result.error(CodeMsg.MIAO_SHA_OVER);
        }
        //预减库存
        Long stock = redisService.decr(GoodsKey.getMiaoshaGoodsStock, "" + goodsId);
        if (stock < 0){
            localOverMap.put(goodsId, true);
            return Result.error(CodeMsg.MIAO_SHA_OVER);
        }
        //判断是否已经秒杀到了
        MiaoshaOrder order = orderService.getMiaoshaOrderByUserIdGoodsId(user.getId(), goodsId);
        if (order != null){
            return Result.error(CodeMsg.REPEATE_MIAOSHA);
        }
        //入队
        MiaoshaMessage mm = new MiaoshaMessage();
        mm.setUser(user);
        mm.setGoodsId(goodsId);
        mqSender.sendMiaoshaMessage(mm);
        return Result.success(0);//排队中
    }

    /**
     * orderId：成功
     * -1：秒杀失败
     * 0： 排队中
     * */
    @RequestMapping(value="/result", method=RequestMethod.GET)
    @ResponseBody
    public Result<Long> miaoshaResult(Model model,MiaoshaUser user,
                                      @RequestParam("goodsId")long goodsId) {
        model.addAttribute("user", user);
        if(user == null) {
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        long result  =miaoshaService.getMiaoshaResult(user.getId(), goodsId);
        return Result.success(result);
    }

    /**
     * 获取秒杀路径
     * @param request
     * @param user
     * @param goodsId
     * @param verifyCode
     * @return
     */
    @AccessLimit(second=5, maxCount=5, needLogin=true)
    @RequestMapping(value="/path", method=RequestMethod.GET)
    @ResponseBody
    public Result<String> getMiaoshaPath(HttpServletRequest request, MiaoshaUser user,@RequestParam("goodsId") Long goodsId,
                                         @RequestParam(value = "verifyCode",defaultValue = "0") int verifyCode){
        if (user == null){
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        boolean checkVerifyCode = miaoshaService.checkVerifyCode(user, goodsId, verifyCode);
        if (!checkVerifyCode){
            return Result.error(CodeMsg.REQUEST_ILLEGAL);
        }
        String path = miaoshaService.createMiaoshaPath(user,goodsId);
        return Result.success(path);
    }

    @RequestMapping(value="/verifyCode", method= RequestMethod.GET)
    @ResponseBody
    public Result<String> getMiaoshaVerifyCod(HttpServletResponse response, MiaoshaUser user,
                                              @RequestParam("goodsId")long goodsId) {
        if(user == null) {
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        try {
            BufferedImage image  = miaoshaService.createVerifyCode(user, goodsId);
            OutputStream out = response.getOutputStream();
            ImageIO.write(image, "JPEG", out);
            out.flush();
            out.close();
            return null;
        }catch(Exception e) {
            e.printStackTrace();
            return Result.error(CodeMsg.MIAOSHA_FAIL);
        }
    }

}

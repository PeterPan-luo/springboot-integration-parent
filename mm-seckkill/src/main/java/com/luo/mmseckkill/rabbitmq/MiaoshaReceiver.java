package com.luo.mmseckkill.rabbitmq;

import com.luo.mmseckkill.model.MiaoshaOrder;
import com.luo.mmseckkill.model.MiaoshaUser;
import com.luo.mmseckkill.redis.RedisService;
import com.luo.mmseckkill.service.GoodsService;
import com.luo.mmseckkill.service.MiaoshaService;
import com.luo.mmseckkill.service.OrderService;
import com.luo.mmseckkill.vo.GoodsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MiaoshaReceiver {

    @Autowired
    RedisService redisService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;

    @Autowired
    MiaoshaService miaoshaService;

    /**
     * 秒杀订订单处理
     * @param message
     */
    @RabbitListener(queues = MqConfig.MIAOSHA_QUEUE)
    public void miaoshaRecive(String message){
        log.info("receive message:"+message);
        MiaoshaMessage mm  = RedisService.stringToBean(message, MiaoshaMessage.class);
        MiaoshaUser user = mm.getUser();
        long goodsId = mm.getGoodsId();

        GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
        int stock = goods.getStockCount();
        if(stock <= 0) {
            return;
        }
        //判断是否已经秒杀到了
        MiaoshaOrder order = orderService.getMiaoshaOrderByUserIdGoodsId(user.getId(), goodsId);
        if(order != null) {
            return;
        }

        //减库存 下订单 写入秒杀订单
        miaoshaService.miaosha(user, goods);
    }
}

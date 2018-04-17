package com.luo.mmseckkill.access;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Strings;
import com.luo.mmseckkill.model.MiaoshaUser;
import com.luo.mmseckkill.redis.RedisService;
import com.luo.mmseckkill.redis.key.AccessKey;
import com.luo.mmseckkill.result.CodeMsg;
import com.luo.mmseckkill.result.Result;
import com.luo.mmseckkill.service.MiaoshaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import sun.awt.windows.WLightweightFramePeer;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.invoke.MethodHandle;

@Component
public class AccessInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private MiaoshaUserService userService;

    @Autowired
    RedisService redisService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod){
            MiaoshaUser user = getUser(request, response);
            UserContextHolder.setUser(user);
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            AccessLimit accessAnno = handlerMethod.getMethodAnnotation(AccessLimit.class);
            if (accessAnno == null)
                return true;
            int second = accessAnno.second();
            int maxCount = accessAnno.maxCount();
            boolean needLogin = accessAnno.needLogin();
            String key = request.getRequestURI();
            if (needLogin){
                if (user == null){
                    render(response, CodeMsg.SESSION_ERROR);
                    return false;
                }
                key += "_" + user.getId();
            }else {

            }
            AccessKey ak = AccessKey.withExpire(second);
            Integer count = redisService.get(ak, key, Integer.class);
            if (count == null){
                redisService.set(ak, key, 1);
            }else if (count < maxCount){
                redisService.incr(ak, key);
            }else {
                render(response, CodeMsg.ACCESS_LIMIT_REACHED);
                return false;
            }
        }
        return  true;
    }

    private void render(HttpServletResponse response, CodeMsg codeMsg) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        OutputStream outputStream = response.getOutputStream();
        String jsonString = JSON.toJSONString(Result.error(codeMsg));
        outputStream.write(jsonString.getBytes("UTF-8"));
        outputStream.flush();
        outputStream.close();

    }

    private MiaoshaUser getUser(HttpServletRequest request, HttpServletResponse response) {
        String paramToken = request.getParameter(MiaoshaUserService.COOKI_NAME_TOKEN);
        String cookieToken = getCookieValue(request, MiaoshaUserService.COOKI_NAME_TOKEN);
        if(Strings.isNullOrEmpty(cookieToken) && Strings.isNullOrEmpty(paramToken)) {
            return null;
        }
        String token = Strings.isNullOrEmpty(paramToken)?cookieToken:paramToken;
        return userService.getByToken(response, token);
    }

    private String getCookieValue(HttpServletRequest request, String cookiName) {
        Cookie[]  cookies = request.getCookies();
        if(cookies == null || cookies.length <= 0){
            return null;
        }
        for(Cookie cookie : cookies) {
            if(cookie.getName().equals(cookiName)) {
                return cookie.getValue();
            }
        }
        return null;
    }
}

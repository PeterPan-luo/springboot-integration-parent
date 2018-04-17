package com.luo.mmseckkill.access;

import com.luo.mmseckkill.model.MiaoshaUser;

public class UserContextHolder {

    private static ThreadLocal<MiaoshaUser> userHolder = new ThreadLocal<>();

    public static void setUser(MiaoshaUser user){
        userHolder.set(user);
    }

    public static MiaoshaUser getUser(){
        return userHolder.get();
    }
}

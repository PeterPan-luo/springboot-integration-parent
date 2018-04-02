package com.study.sell.service;

import com.google.common.base.Strings;
import com.study.sell.exception.SellException;
import lombok.extern.slf4j.Slf4j;
import org.simpleframework.xml.core.Commit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RedisLock {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 加锁
     * @param key
     * @param value 当前时间+超时时间
     */
    public boolean lock(String key, String value){
        if (redisTemplate.opsForValue().setIfAbsent(key,value)){
            return true;
        }
        //如果锁过期
        String currentVal = redisTemplate.opsForValue().get(key);
        if (!Strings.isNullOrEmpty(currentVal) &&
                Long.parseLong(currentVal) < System.currentTimeMillis()){
            //获得上一个锁时间
            // 防止多线程问题，第一个线程获得值后进行修改，第二个线程进来的时候获取的是已经修改过的值，所以不能再获得锁
            String oldVal = redisTemplate.opsForValue().getAndSet(key, value);
            if (!Strings.isNullOrEmpty(oldVal) && oldVal.equals(currentVal)){
                return true;
            }
        }
        return false;
    }

    /**
     * 解锁
     * @param key
     * @param value
     */
    public void unlock(String key, String value){

        try {
            String currentVal = redisTemplate.opsForValue().get(key);
            if (!Strings.isNullOrEmpty(currentVal) && currentVal.equals(value)){
                redisTemplate.opsForValue().getOperations().delete(key);
            }
        }catch (Exception e){
            log.error("redis分布式锁解锁异常");
        }


    }

    public static void main(String[] args) {
        long time = System.currentTimeMillis() + 10* 1000;
        RedisLock redisLock = new RedisLock();
        //加锁
        if (!redisLock.lock("productid", String.valueOf(time))) {
            throw new SellException(101, "人太多...");
        }
        //....业务代码


        //解锁
        redisLock.unlock("productid", String.valueOf(time)));
    }
}

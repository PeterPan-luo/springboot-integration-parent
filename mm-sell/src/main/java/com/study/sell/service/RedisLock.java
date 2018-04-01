package com.study.sell.service;

import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.simpleframework.xml.core.Commit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

@Commit
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
            String oldVal = redisTemplate.opsForValue().getAndSet(key, value);
            if (!Strings.isNullOrEmpty(oldVal) && oldVal.equals(currentVal)){
                return true;
            }
        }
        return false;
    }
}

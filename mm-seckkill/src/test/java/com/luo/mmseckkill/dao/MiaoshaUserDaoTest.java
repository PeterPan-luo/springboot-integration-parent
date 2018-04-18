package com.luo.mmseckkill.dao;

import com.luo.mmseckkill.model.MiaoshaUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MiaoshaUserDaoTest {

    @Autowired
    MiaoshaUserDao miaoshaUserDao;

    @Test
    public void getById() {
        MiaoshaUser miaoshaUser = miaoshaUserDao.getById(Long.valueOf("15071027574"));
        System.out.println(miaoshaUser);
    }

    @Test
    public void update() {
    }
}
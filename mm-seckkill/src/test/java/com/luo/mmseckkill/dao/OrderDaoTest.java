package com.luo.mmseckkill.dao;

import com.luo.mmseckkill.model.MiaoshaOrder;
import com.luo.mmseckkill.model.OrderInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Random;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDaoTest {

    @Autowired
    OrderDao orderDao;

    @Test
    public void getMiaoshaOrderByUserIdGoodsId() {
    }

    @Test
    public void insert() {

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setCreateDate(new Date());
        orderInfo.setDeliveryAddrId(0L);
        orderInfo.setGoodsCount(1);
        orderInfo.setGoodsId(new Random(1000).nextLong());
        orderInfo.setGoodsName("test");
        orderInfo.setGoodsPrice(10.0);
        orderInfo.setOrderChannel(1);
        orderInfo.setStatus(0);
        orderInfo.setUserId(11L);
        orderDao.insert(orderInfo);
    }

    @Test
    public void insertMiaoshaOrder() {
        MiaoshaOrder miaoshaOrder = new MiaoshaOrder();
        miaoshaOrder.setGoodsId(new Random(1000).nextLong());
        miaoshaOrder.setOrderId(1L);
        miaoshaOrder.setUserId(1L);
        orderDao.insertMiaoshaOrder(miaoshaOrder);
    }

    @Test
    public void getOrderById() {
    }

    @Test
    public void deleteOrders() {
    }

    @Test
    public void deleteMiaoshaOrders() {
    }
}
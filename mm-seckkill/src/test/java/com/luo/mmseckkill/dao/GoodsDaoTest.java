package com.luo.mmseckkill.dao;

import com.luo.mmseckkill.vo.GoodsVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsDaoTest {

    @Autowired
    GoodsDao goodsDao;

    @Test
    public void listGoodsVo() {
        List<GoodsVo> goodsVoList = goodsDao.listGoodsVo();
        System.out.println(goodsVoList);
        System.out.println(goodsVoList.size());
    }

    @Test
    public void getGoodsVoByGoodsId() {
    }

    @Test
    public void reduceStock() {
    }

    @Test
    public void resetStock() {
    }
}
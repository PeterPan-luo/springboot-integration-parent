package com.study.sell.service.impl;

import com.study.sell.dataobject.SellerInfo;
import com.study.sell.repository.SellerInfoRepository;
import com.study.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;

public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}

package com.luo.study.mmmapper.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luo.study.mmmapper.mapper.AccountEntityMapper;
import com.luo.study.mmmapper.model.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountEntityMapper accountEntityMapper;

    public AccountEntity getAccountInfo() {
        AccountEntity queryEntity = new AccountEntity();
        queryEntity.setKeyId("b80d123dd71a405b866c98f0c52d5c85");
        AccountEntity accountEntity = accountEntityMapper.selectByPrimaryKey(queryEntity);
        return accountEntity;
    }

    public List<AccountEntity> getAllAccount(){
        return accountEntityMapper.selectAll();
    }

    public PageInfo getAccountByPage(int pageNo, int pageSize){
        PageHelper.startPage(pageNo, pageSize);
        List<AccountEntity> accountEntities = accountEntityMapper.selectAll();
        PageInfo page = new PageInfo(accountEntities);
        return page;
    }
}

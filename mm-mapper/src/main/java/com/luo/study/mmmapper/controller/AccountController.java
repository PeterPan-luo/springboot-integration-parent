package com.luo.study.mmmapper.controller;

import com.luo.study.mmmapper.model.AccountEntity;
import com.luo.study.mmmapper.service.AccountService;
import com.luo.study.mmmapper.util.ResultVOUtil;
import com.luo.study.mmmapper.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/getAccountInfo")
    public ResultVO getAccountInfo(){
        AccountEntity accountInfo = accountService.getAccountInfo();
        return  ResultVOUtil.success(accountInfo);
    }
}

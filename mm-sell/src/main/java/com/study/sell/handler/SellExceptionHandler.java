package com.study.sell.handler;

import com.study.sell.config.ProjectUrlConfig;
import com.study.sell.exception.ResponseBankException;
import com.study.sell.exception.SellException;
import com.study.sell.exception.SellerAuthorizeException;
import com.study.sell.utils.ResultVOUtil;
import com.study.sell.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class SellExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @ExceptionHandler( value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException(){

        return new ModelAndView("redirect:"
                .concat(projectUrlConfig.getWechatOpenAuthorize())
                .concat("/sell/wechat/qrAuthorize")
                .concat("?returnUrl=")
                .concat(projectUrlConfig.getSell())
                .concat("/sell/seller/login"));
    }

    @ExceptionHandler( value = SellException.class)
    @ResponseBody
    public ResultVO handleSellException(SellException e){
        return ResultVOUtil.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler( value = ResponseBankException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handleResponseBankException(){

    }
}

package com.study.sell.exception;

import com.study.sell.enums.ResultEnum;

public class SellException extends RuntimeException {

    private  Integer code;

    public SellException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
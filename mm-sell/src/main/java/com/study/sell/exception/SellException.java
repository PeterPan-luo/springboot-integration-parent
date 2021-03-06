package com.study.sell.exception;

import com.study.sell.enums.ResultEnum;
import lombok.Data;

@Data
public class SellException extends RuntimeException {

    private  Integer code;

    public SellException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

}

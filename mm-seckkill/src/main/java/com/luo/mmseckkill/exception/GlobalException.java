package com.luo.mmseckkill.exception;

import com.luo.mmseckkill.result.CodeMsg;
import lombok.Getter;

@Getter
public class GlobalException extends RuntimeException {

    private CodeMsg cm;

    public GlobalException(CodeMsg cm) {
        super(cm.getMsg());
        this.cm = cm;
    }
}

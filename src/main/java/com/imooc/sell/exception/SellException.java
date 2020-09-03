package com.imooc.sell.exception;

import com.imooc.sell.enums.ResultEnum;

import javax.persistence.criteria.CriteriaBuilder;

public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}

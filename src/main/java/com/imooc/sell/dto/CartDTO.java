package com.imooc.sell.dto;

import lombok.Data;

//为了避免混乱，避免同时映射数据库字段，同时给controller用，一般实体类就单纯映射表；而新建DTO给controller那边用
@Data
public class CartDTO {

    /** 商品ID. */
    private String productId;
    /** 数量. */
    private Integer productquantity;

    public CartDTO(String productId, Integer productquantity) {
        this.productId = productId;
        this.productquantity = productquantity;
    }
}

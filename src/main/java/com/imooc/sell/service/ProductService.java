package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductInfo;

import java.util.List;

public interface ProductService {
    ProductInfo findById(String productId);

    /**
     * 客户端查询所有在架商品列表
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 服务端查询所有商品列表
     * @return
     */
    List<ProductInfo> findAll();

    /**
     * 保存商品、
     * @param productInfo
     * @return
     */
    ProductInfo save(ProductInfo productInfo);



    //加库存

    //减库存

}

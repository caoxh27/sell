package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
     * 分页返回，使用 Pageable 作为参数，返回值需要指定为Page对象
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 保存商品、
     * @param productInfo
     * @return
     */
    ProductInfo save(ProductInfo productInfo);



    //加库存
    //加减库存，不用返回数据，如果有错误，直接抛异常就好了
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void dereaseStock(List<CartDTO> cartDTOList);

}

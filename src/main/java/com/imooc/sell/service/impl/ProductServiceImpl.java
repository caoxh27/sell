package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.dto.CartDTO;
import com.imooc.sell.enums.ProductStatusEnum;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.repository.ProductInfoRepository;
import com.imooc.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    //引入我们的dao对象，在各自类里面的私有对象，实例对象可以同名
    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findById(String productId) {
        ProductInfo productInfo = null;
        Optional<ProductInfo> productOptional = repository.findById(productId);
        if (productOptional.isPresent()) {
            productInfo = productOptional.get();
            System.out.println(productInfo.toString());
        } else {
            // handle not found, return null or throw
            System.out.println("productInfo no exit!");
        }
        return productInfo;
    }

    @Override
    public List<ProductInfo> findUpAll() {
        /**
         * 查询在架的商品，状态代码 0;
         * 代码里面为了避免因为重复出现的代码值，时间久了容易混淆忘记的问题，使用枚举来替代代码值;
         * 根据枚举单词的意思，增强了代码的可读性;
         */
        //return repository.findByProductStatus(0);
        return  repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO:cartDTOList){
            ProductInfo productInfo = repository.findById(cartDTO.getProductId()).get();
            if(productInfo == null){
                throw  new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result = productInfo.getProductStock() + cartDTO.getProductquantity();
            productInfo.setProductStock(result);
            repository.save(productInfo);

        }
    }

    @Override
    @Transactional
    public void dereaseStock(List<CartDTO> cartDTOList) {
        /**
         * 减库存，根据购物车参数，对每一种商品，判断该商品的库存够不够，够即减，不够则抛出异常
         */
        for(CartDTO cartDTO:cartDTOList){
            ProductInfo productInfo = repository.findById(cartDTO.getProductId()).get();
            if(productInfo == null){
                throw  new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result = productInfo.getProductStock() - cartDTO.getProductquantity();
            if(result < 0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);
            repository.save(productInfo);

        }

    }
}

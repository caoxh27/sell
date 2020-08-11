package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductCategory;
import com.imooc.sell.repository.ProductCategoryRepository;
import com.imooc.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//服务层，需要加上我们的 @Service 注解
public class CategoryServiceImpl implements CategoryService {

    @Autowired  //引入我们的dao对象
    private ProductCategoryRepository repository;

    @Override
    public ProductCategory findById(Integer categoryId) {
        return repository.findById(categoryId).get();
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findBycategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findBycategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}

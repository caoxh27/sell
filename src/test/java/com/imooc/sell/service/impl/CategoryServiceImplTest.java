package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findById() {
        ProductCategory productCategory = categoryService.findById(4);
        assertEquals(new Integer(1), productCategory.getCategoryId());
    }

    @Test
    void findAll() {
        List<ProductCategory> productCategoryList = categoryService.findAll();
        assertNotEquals(0,productCategoryList.size());
    }

    @Test
    void findBycategoryTypeIn() {
        //List<ProductCategory> productCategoryList = categoryService.findBycategoryTypeIn(Arrays.asList(1,2,3,4));
        List<Integer> list = Arrays.asList(2,3,4);
        List<ProductCategory> productCategoryList = categoryService.findBycategoryTypeIn(list);
        assertNotEquals(0,productCategoryList.size());
    }

    @Test
    @Transactional
    void save() {
        ProductCategory productCategory = new ProductCategory("闷声不答",11);
        ProductCategory result = categoryService.save(productCategory);
        assertNotNull(result);

    }
}
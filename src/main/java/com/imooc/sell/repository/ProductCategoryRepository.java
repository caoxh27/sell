package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * DAO层，也经常说是 repository,注意这里不是类，而是一个接口
 * 这里通过JPA来实现对 DB 的操作；  还有一个可选的选项是 mybatis
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    List<ProductCategory> findBycategoryTypeIn(List<Integer> categoryTypeList);
}

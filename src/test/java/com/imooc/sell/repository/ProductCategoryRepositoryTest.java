package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;

import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


//和Junit4 还是有些不同的。
// 首先，导入测试测试注解（@Test）和断言方法（assertEquals）的路径不同。
// 其次，不需要手动把测试和测试方法声明为 public 了。
@SpringBootTest
class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findByIdTest(){
        //老版本
        //ProductCategory productCategory = repository.findOne(1);

        ProductCategory productCategory = repository.findById(1).get();
        System.out.println(productCategory.toString());
//        ProductCategory productCategory1 = repository.findById(1).orElse(null);
//        System.out.println(productCategory1.toString());
//        ProductCategory productCategory2 = repository.getOne(1);
//        System.out.println(productCategory2.toString());

    }
    //新增记录，data jpa用的是 save方法； 新建一个对象，再save(), createTime,updateTime都会自动更新；
    //对于查出来的对象，不显式指定，则用原来的值； 要是不想手写，则在类上使用动态更新的注解
    @Test
    public void saveTest1(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("女生最爱");
        productCategory.setCategoryType(2);
        repository.save(productCategory);
    }

    @Test
    public void saveTest2(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(2);
        productCategory.setCategoryName("AA最爱");
        productCategory.setCategoryType(3);
        repository.save(productCategory);
    }

    //更新记录，data jpa用的也是 save方法； 新建一个对象，再save(), updateTime会有数据看自动更新；
    //对于查出来的对象，不显式指定，则用原来的值； 要是不想手写，则在类上使用动态更新的注解
    @Test
    public void saveTest3(){
        ProductCategory productCategory = repository.findById(2).get();
        productCategory.setCategoryType(3);
        repository.save(productCategory);
    }

    @Test
    @Transactional
    //在单元测试中， 事务注解，是完全回滚；
    //在正常的业务方法中，事务注解，是当方法有报出异常的时候，回滚事务。
    public void saveTest4(){
        //注意要有两个构造方法， 且 空参数的构造方法显式在前面。
        ProductCategory productCategory = new ProductCategory("事务测试",5);
        ProductCategory result = repository.save(productCategory);
        assertNotNull(result);
    }

    @Test
    public void findBycategoryTypeInTest(){
        List<Integer> list = Arrays.asList(2,3,4);
        List<ProductCategory> result = repository.findBycategoryTypeIn(list);
        assertNotNull(result);

    }

}
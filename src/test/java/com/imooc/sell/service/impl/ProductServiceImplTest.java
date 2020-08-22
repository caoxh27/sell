package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.enums.ProductStatusEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//和Junit4 还是有些不同的。
//首先，导入测试测试注解（@Test）和断言方法（assertEquals）的路径不同。
//其次，不需要手动把测试和测试方法声明为 public 了。
@SpringBootTest
class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    void findById() {
        ProductInfo productInfo = productService.findById("123456");
        Assertions.assertEquals("123456",productInfo.getProductId());
    }

    @Test
    void findUpAll() {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assertions.assertNotEquals(0,productInfoList.size());
    }

    @Test
    void findAll() {
        //Pageable (int, int) 提示已经过时，替代的方法是不要new PageRequest;
        //而是直接用 PageRequest.of这个方法 根据你的需求选择入参；
        //优点：利用构造方法，调用处写死了必须使用new来创建新的对象，对象的控制权在调用处，而调用of方法则把生成对象的控制权保留在了PageRequest类中，后期如果需要扩展则在PageRequest类中进行扩展即可
        //PageRequest request = new PageRequest(0,2);
        PageRequest request = PageRequest.of(0,2);
        Page<ProductInfo> productInfoPage = productService.findAll(request);
        // System.out.println(productInfoPage.getTotalElements());
        Assertions.assertNotEquals(0,productInfoPage.getSize());
    }

    @Test
    void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("肉丸子");
        productInfo.setProductPrice(new BigDecimal(24.5));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("曹锐霖最喜欢的肉丸子");
        productInfo.setProductIcon("http://xxx.xxx.com/rouwanzi.jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(2);

        ProductInfo result = productService.save(productInfo);
        Assertions.assertNotNull(result);
    }
}
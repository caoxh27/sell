package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//和Junit4 还是有些不同的。
// 首先，导入测试测试注解（@Test）和断言方法（assertEquals）的路径不同。
// 其次，不需要手动把测试和测试方法声明为 public 了。
@SpringBootTest
class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("菜包子");
        productInfo.setProductPrice(new BigDecimal(12.5));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("曹锐霖最喜欢的菜包子");
        productInfo.setProductIcon("http://xxx.xxx.com/caobaozi.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);

        ProductInfo result = repository.save(productInfo);
        assertNotNull(result);
    }

    @Test
    void findByProductStatus() {
        List<ProductInfo> productInfoList =  repository.findByProductStatus(0);
        assertNotEquals(0,productInfoList.size());


    }
}
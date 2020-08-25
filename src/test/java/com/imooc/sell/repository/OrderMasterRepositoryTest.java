package com.imooc.sell.repository;

import com.imooc.sell.dataobject.OrderMaster;
import com.imooc.sell.dataobject.ProductCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID = "110110";

    @Test
    public void save() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234560");
        orderMaster.setBuyerName("师兄0");
        orderMaster.setBuyerPhone("123456789123");
        orderMaster.setBuyerAddress("幕课网");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(5.5));
        orderMaster.setCreateTime(new Date());
        orderMaster.setUpdateTime(new Date());

// @DynamicUpdate@DynamicInsert 是hibernate里面的注解，这两个注解加上之后就不会为字段值不变的字段生成sql语句，这样sql的长度就减少了提高了传输效率和执行效率，
// 在做修改的时候，千万不要以为这两个注解不会为字段值为null的字段生成sql，如果前端传进来一个实体对象，部分字段没有传，这时候如果使用xxxRepository.save(entity) 方法，他会把null的字段设置为空，而不是不生成sql，
// 如果你想要字段值为null的时候不生成sql，又不想再查一遍对象可以使用 CriteriaUpdate 对象更新你需要的字段

        OrderMaster result = repository.save(orderMaster);
        Assertions.assertNotNull(result);
    }

    //更新记录，data jpa用的也是 save方法；
    //对于查出来的对象，不显式指定，则用原来的值； 要是不想手写，则在类上使用动态更新的注解
    @Test
    public void update(){
        OrderMaster orderMaster = repository.findById("1234568").get();
        orderMaster.setUpdateTime(new Date());
        OrderMaster result = repository.save(orderMaster);
    }

    @Test
    void findByBuyerOpenid() {
        PageRequest request = PageRequest.of(0, 3);

        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID, request);

        Assertions.assertNotEquals(0, result.getTotalElements());
    }
}
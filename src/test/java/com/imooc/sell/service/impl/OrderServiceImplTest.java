package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.enums.OrderStatusEnum;
import com.imooc.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYER_OPENID="1101110";
    private final String ORDER_ID = "1599381185271490498";

    @Test
    void create() {
        //单元测试，原来方法传入的参数，需自行构建
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("小胖墩");
        orderDTO.setBuyerAddress("南山脚下");
        orderDTO.setBuyerPhone("15017911672");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("123451");
        o1.setProductQuantity(1);

        OrderDetail o2 = new OrderDetail();
        o2.setProductId("123457");
        o2.setProductQuantity(2);

        orderDetailList.add(o1);
        orderDetailList.add(o2);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】result={}",result);
        Assertions.assertNotNull(result);

    }

    @Test
    void findOne() {
        OrderDTO result = orderService.findOne(ORDER_ID);
        log.info("【查询单个订单】result={}",result);
        Assertions.assertEquals(ORDER_ID,result.getOrderId());
    }

    @Test
    void findList() {
        //Pageable (int, int) 提示已经过时，替代的方法是不要new PageRequest;
        //而是直接用 PageRequest.of这个方法 根据你的需求选择入参；
        //优点：利用构造方法，调用处写死了必须使用new来创建新的对象，对象的控制权在调用处，而调用of方法则把生成对象的控制权保留在了PageRequest类中，后期如果需要扩展则在PageRequest类中进行扩展即可
        //PageRequest request = new PageRequest(0,2);
        PageRequest request = PageRequest.of(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID,request);
        Assertions.assertNotEquals(0,orderDTOPage.getTotalElements());

    }

    @Test
    void cancel() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.cancel(orderDTO);
        Assertions.assertEquals(OrderStatusEnum.CANCEL.getCode(),result.getOrderStatus());
    }

    @Test
    void finish() {
    }

    @Test
    void paid() {
    }

    @Test
    void testFindList() {
    }
}
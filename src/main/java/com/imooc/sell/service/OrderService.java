package com.imooc.sell.service;

import com.imooc.sell.dataobject.OrderMaster;
import com.imooc.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * DAO层，数据库的 CURD 创建（Create）、更新（Update）、读取（Retrieve）和删除（Delete）操作;
 * Controller层，数据结果的展现；
 * Service层，所有业务逻辑的实现；
 */
/**
 * 实现步骤，思路：
 * 1. 通过注释，列出需要哪些方法方法
 *
 */

public interface OrderService {
    /** 创建订单. */
    //思考下，把数据库实体对象返回给controller是否方便？ 特别是返回的订单信息还包含订单详情的时候。
    //入参用 DTO， 和  Mater，Detail 对象与对象间存在对象转换
    //OrderMaster create(OrderMaster orderMaster);
    OrderDTO create(OrderDTO orderDTO);

    /** 查询单个订单. */
    OrderDTO findOne(String orderId);

    /** 查询订单列表. */
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /** 取消订单. */
    OrderDTO cancel(OrderDTO orderDTO);

    /** 接单 --- 完结订单. */
    OrderDTO finish(OrderDTO orderDTO);

    /** 支付订单. */
    OrderDTO paid(OrderDTO orderDTO);

    /** 查询订单列表. */
    Page<OrderDTO> findList(Pageable pageable);
}

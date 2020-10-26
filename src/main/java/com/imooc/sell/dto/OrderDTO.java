package com.imooc.sell.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//为了避免混乱，避免同时映射数据库字段，同时给controller用，一般实体类就单纯映射表；而新建DTO给controller那边用
@Data
@DynamicUpdate

//处理返回的 null 值，不做返回；全局配置的配置文件里面
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    /** 订单id. */
    private String orderId;

    /** 买家名字. --前端传入*/
    private String buyerName;

    /** 买家手机号. --前端传入 */
    private String buyerPhone;

    /** 买家地址. --前端传入 */
    private String buyerAddress;

    /** 买家微信Openid. --前端传入 */
    private String buyerOpenid;

    /** 订单总金额. -- 需要计算*/
    private BigDecimal orderAmount;

    /** 订单状态, 默认为0新下单. DTO不需要初始值 */
    private Integer orderStatus;

    /** 支付状态, 默认为0未支付. DTO不需要初始值 */
    private Integer payStatus;

    /** 创建时间. */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime = new Date();

    /** 更新时间. */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime = new Date();

    //如果需求返回不能为null,可以返回一个初始值 ArrayList
    //TODO v20200927
    //private List<OrderDetail> orderDetailList = new ArrayList<>();
    private List<OrderDetail> orderDetailList;
}

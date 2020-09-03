package com.imooc.sell.dto;

import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.enums.OrderStatusEnum;
import com.imooc.sell.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
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
    private Date createTime;

    /** 更新时间. */
    private Date updateTime;

    private List<OrderDetail> orderDetailList;
}

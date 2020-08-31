package com.imooc.sell.dataobject;

import com.imooc.sell.enums.OrderStatusEnum;
import com.imooc.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data

//默认值是false,加了就是true,有 @DynamicInsert 注解的效果：
//Hibernate: insert into Cat (cat_name, id) values (?, ?)
//默认值是false,没有加就是false,无 @DynamicInsert 注解的效果：
//Hibernate: insert into Cat (create_time, update_time, cat_name, id) values (?, ?, ?, ?)
//为了业务可靠，默认不加，显式指定变量值
//@DynamicInsert

//为了 updateTime 自动更新，需要使用 @DynamicUpdate 注解
//默认值是false,加了就是true,有 @DynamicUpdate 注解的效果：
//Hibernate: update Cat set update_time=? where id=?
// --- 说明：如果字段有更新，Hibernate才会对该字段进行更新
//默认值是false,没有加就是false,无 @DynamicUpdate 注解的效果：
//Hibernate: update Cat set update_time=?, cat_name=? where id=?
// --- 说明：不管字段有没有更新，Hibernate都会对该字段进行更新

@DynamicUpdate

// @DynamicUpdate@DynamicInsert 是hibernate里面的注解，这两个注解加上之后就不会为字段值不变的字段生成sql语句，这样sql的长度就减少了提高了传输效率和执行效率，
// 在做修改的时候，千万不要以为这两个注解不会为字段值为null的字段生成sql，如果前端传进来一个实体对象，部分字段没有传，这时候如果使用xxxRepository.save(entity) 方法，他会把null的字段设置为空，而不是不生成sql，
// 如果你想要字段值为null的时候不生成sql，又不想再查一遍对象可以使用 CriteriaUpdate 对象更新你需要的字段

public class OrderMaster {

    /** 订单id. */
    @Id
    private String orderId;

    /** 买家名字. */
    private String buyerName;

    /** 买家手机号. */
    private String buyerPhone;

    /** 买家地址. */
    private String buyerAddress;

    /** 买家微信Openid. */
    private String buyerOpenid;

    /** 订单总金额. */
    private BigDecimal orderAmount;

    /** 订单状态, 默认为0新下单. */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** 支付状态, 默认为0未支付. */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** 创建时间. */
    private Date createTime;

    /** 更新时间. */
    //为了 updateTime 自动更新，需要使用 @DynamicUpdate 注解
    private Date updateTime;

    //关联用，一般不这么做；避免混乱，一般实体类就单纯映射表；而新建DTO给controller那边用
    //@Transient
    //private List<OrderDetail> orderDetailList;
}

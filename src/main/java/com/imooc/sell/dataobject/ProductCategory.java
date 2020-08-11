package com.imooc.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 数据库对象，表和对象的映射，可以是 DTO
 */

/**
 * 类目
 * 表 product_category   <--->  类 ProductCategory ，jpa完成下划线表名和驼峰式类名称的自动映射
 * jpa  @Table(name = "s_product_category")  支持显式的手动指定映射关系
 */

//jpa 把数据库表映射为对象，需要用到 Entity 注解
@Entity
// @Proxy(lazy = false) 解决jpa懒加载问题
@DynamicUpdate
@Data
public class ProductCategory {
    /**类目id. 使用 主键，自增类型注解 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    /**类目名字. */
    private String categoryName;
    /**类目编号. */
    private Integer categoryType;

    /*private Date createTime;

    private Date updateTime;*/

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    /*public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryType=" + categoryType +
                '}';
    }*/
}

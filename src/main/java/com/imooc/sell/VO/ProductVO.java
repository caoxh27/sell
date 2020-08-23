package com.imooc.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品（包含类目） -- 应该说是商品分类
 *  * 根据接口字段来设计返回的对象；
 *  * API接口文档,是根据需求，最后由后台设计，和前端沟通，定版；
 *  * 最后前后端根据API问题各自开发，然后联调
 */
@Data
public class ProductVO {
    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;

}

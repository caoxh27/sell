package com.imooc.sell.VO;

import lombok.Data;

/**
 * http请求返回的最外层对象
 * 根据接口字段来设计返回的对象；
 * API接口文档,是根据需求，最后由后台设计，和前端沟通，定版；
 * 最后前后端根据API问题各自开发，然后联调
 */
@Data
public class ResultVO<T> {
    /** 错误码. */
    private Integer code;
    /** 提示信息. */
    private String msg;
    /** 具体内容；因为是对象，所以使用泛型. */
    private T data;

}

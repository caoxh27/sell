package com.imooc.sell.utils;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Random;

public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式：时间+随机数
     * 毫秒 + 6位随机数，正常情况下，满足订单的主键生成；
     * 在多线程并发场景，可以使用synchronized关键字，避免重复数据
     * @return
     */

    //

    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }


}

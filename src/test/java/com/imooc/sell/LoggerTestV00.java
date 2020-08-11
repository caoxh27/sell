package com.imooc.sell;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class LoggerTestV00 {
    //写日志，需要引入一个类（Logger）, 入参是当前所在类的类名
    private final Logger logger = LoggerFactory.getLogger(LoggerTestV00.class);

    @Test
    public void test1(){

//        ERROR(40, "ERROR"),
//        WARN(30, "WARN"),
//        INFO(20, "INFO"),
//        DEBUG(10, "DEBUG"),
//        TRACE(0, "TRACE");
        logger.debug("debug...");
        logger.info("info...");
        logger.error("error...");
    }
}

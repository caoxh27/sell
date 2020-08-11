package com.imooc.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
//添加 Slf4j 注解
@Slf4j
public class LoggerTestV01 {
    //写日志，需要引入一个类（Logger）, 入参是当前所在类的类名
    //private final Logger logger = LoggerFactory.getLogger(LoggerTestV02.class);

    @Test
    public void test1(){

//        ERROR(40, "ERROR"),
//        WARN(30, "WARN"),
//        INFO(20, "INFO"),   //默认
//        DEBUG(10, "DEBUG"),
//        TRACE(0, "TRACE");
        log.debug("debug...");
        log.info("info...");
        log.error("error...");
    }
}

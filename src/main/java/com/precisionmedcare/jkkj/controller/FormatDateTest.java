package com.precisionmedcare.jkkj.controller;

import com.precisionmedcare.jkkj.model.TestEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @program:hope
 * @author:qlh
 * @create:2019-08-28 16:51
 **/
@RestController
public class FormatDateTest {
    private static final Logger log= LoggerFactory.getLogger(FormatDateTest.class);

    @GetMapping("/test")
    public TestEntity test(){
        TestEntity testEntity=new TestEntity();
        testEntity.setName("admin");
        testEntity.setDateTimes(LocalDateTime.now());
        log.info("[+++++++++++++]-[{}]", testEntity.getName());
        log.info("[格式化当前时间]-[{}]", testEntity.getDateTimes());
        log.info("[默认当前时间]-[{}]", LocalDateTime.now());
        return testEntity;
    }
}

package com.precisionmedcare.jkkj.model;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @program:hope
 * @author:qlh
 * @create:2019-08-28 16:51
 **/
//加上注释@Component，可以直接在其他地方使用@Autowired来创建其实例对象
//@Component
public class TestEntity {
    private String name;

    public LocalDateTime getDateTimes() {
        return dateTimes;
    }

    public void setDateTimes(LocalDateTime dateTimes) {
        this.dateTimes = dateTimes;
    }

    private LocalDateTime dateTimes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

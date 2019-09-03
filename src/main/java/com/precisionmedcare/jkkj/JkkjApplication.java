package com.precisionmedcare.jkkj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.precisionmedcare.jkkj.mapper")
public class JkkjApplication {

    public static void main(String[] args) {
        SpringApplication.run(JkkjApplication.class, args);
    }

}

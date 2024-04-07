package com.comp5703.yearnmove;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.comp5703.yearnmove.mapper")
public class YearnMoveApplication {

    public static void main(String[] args) {
        SpringApplication.run(YearnMoveApplication.class, args);
    }

}

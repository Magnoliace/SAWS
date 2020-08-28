package com.saws;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@MapperScan("com.saws.dao")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SawsApplication {
    public static void main(String[] args) {
        SpringApplication.run(SawsApplication.class, args);
    }

}

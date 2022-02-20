package com.znrh.project.selfunionproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.znrh.project.selfunionproject.mapper")
public class SelfunionprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SelfunionprojectApplication.class, args);
    }

}

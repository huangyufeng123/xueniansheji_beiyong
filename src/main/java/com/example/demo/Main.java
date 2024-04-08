package com.example.demo;



/*
第一步：entity，定义实体类（和数据库对应）；
第二步：mapper，实现实体类字段映射
第三步：service，实现系统功能（登陆，注册）
第四步：control，处理前端请求


 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
//@MapperScan("com.example.demo.account.mapper")
@MapperScan({"com.example.demo.account.mapper","com.example.demo.Device_Manager.mapper"})
public class Main {

    public static void main(String[] args) {

        SpringApplication.run(Main.class,args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOriginPatterns("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")
                        .allowCredentials(true)
                        .maxAge(3600);
            }
        };
    }

}

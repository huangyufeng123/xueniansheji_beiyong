package com.example.demo.Device_Manager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Shier
 * Knife4j 接口文档配置
 *
 */
@Configuration
@EnableSwagger2
@Profile({"dev", "test"})   //版本控制访问
public class Knife4jConfig {
    @Bean
    public Docket defaultApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 指定 Controller 扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.Device_Manager.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    /**
     * 自定义接口文档信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 接口文档的标题
                .title("农业大棚接口平台管理")
                // 接口文档的描述信息
                .description("农业大棚描述信息")
                // 提供服务的是谁？可以填写你自己的地址因为是你自己提供的服务
                .termsOfServiceUrl("https://github.com/huangyufeng123/bicheng1")
                .contact(new Contact("yufeng", "https://blog.csdn.net/qq_560981912", "29275272341@qq.com"))
                // 版本
                .version("1.0")
                // 构建
                .build();
    }
}
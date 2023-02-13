package com.minzheng.blog.config;

import com.rabbitmq.client.Return;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * @Auther: xucg
 * @Date: 2022/9/18 - 09 - 18 - 17:47
 * @Description: com.minzheng.blog.config
 * @version: 1.0
 */

// 已经被knife4j 替代
// @Configuration
// @EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket Docket() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("xucg").apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.minzheng.blog")).build();
    }

    public ApiInfo apiInfo(){
        Contact contact = new Contact("xcg", "www.gomboclabs.com", "858214058@qq.com");
        ApiInfo apiInfo = new ApiInfo(
                "blog swagger",
                "xcg 的 blog",
                "0.0.1",
                "www.gomboclabs.com",
                "徐纯根",
                "apache2.0",
                "wwww.apache2.0"
        );
        return apiInfo;
    }
}

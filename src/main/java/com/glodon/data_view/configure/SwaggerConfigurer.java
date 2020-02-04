package com.glodon.data_view.configure;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author liuwg-a
 * @date 2019/11/10 15:29
 * @description
 */
@Configuration
@EnableSwagger2
public class SwaggerConfigurer {
    @Bean
    @Autowired
    public Docket createRestApi(TypeResolver typeResolver) {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.glodon.data_view.controller")).paths(PathSelectors.any()).build();
    }

    // 添加应用、服务信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("data_view_demo").contact(new Contact("Jacksonary",
                "https://localhost:8080",
                "jacksonary@github.com")).version("2.0").build();
    }
}

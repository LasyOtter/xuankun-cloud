/**
 * Copyright (c) 2022 旋坤 All rights reserved.
 *
 * https://www.xuankun.com
 *
 * 版权所有，侵权必究！
 */

package com.xuankun.workorder.config;

import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Configuration
@EnableSwagger2WebMvc
@AllArgsConstructor
public class SwaggerConfig{
    private final OpenApiExtensionResolver openApiExtensionResolver;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            //加了ApiOperation注解的类，才生成接口文档
            .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
            //包下的类，才生成接口文档
            //.apis(RequestHandlerSelectors.basePackage("com.xuankun.controller"))
            .paths(PathSelectors.any())
            .build()
            .extensions(openApiExtensionResolver.buildExtensions("xuankun"))
            .directModelSubstitute(java.util.Date.class, String.class)
            .securitySchemes(security());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("旋坤科技")
            .description("运维派单模块接口文档")
            .termsOfServiceUrl("https://xkiot.link/dispatch")
            .version("5.x")
            .build();
    }

    private List<ApiKey> security() {
        return newArrayList(
                new ApiKey("token", "token", "header")
        );
    }

}
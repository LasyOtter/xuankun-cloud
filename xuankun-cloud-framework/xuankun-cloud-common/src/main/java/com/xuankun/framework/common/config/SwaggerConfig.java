package com.xuankun.framework.common.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger配置
 *
 * @author Jimy  545631327@qq.com
 */
@Configuration
public class SwaggerConfig{

    @Bean
    public GroupedOpenApi userApi(){
        String[] paths = { "/**" };
        String[] packagedToMatch = { "com.xuankun" };
        return GroupedOpenApi.builder().group("XuankunCloud")
                .pathsToMatch(paths)
                .packagesToScan(packagedToMatch).build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        Contact contact= new Contact();
        contact.setName("Jimy");

        OpenAPI openapi = new OpenAPI().info(new Info()
            .title("XuankunCloud")
            .description( "XuankunCloud")
            .contact(contact)
            .version("1.0")
            .license(new License().name("MIT")));

        openapi.addSecurityItem(new SecurityRequirement().addList("api_key"))
            .components(new Components().addSecuritySchemes("api_key",
                new SecurityScheme()
                    .name("Authorization")
                    .type(SecurityScheme.Type.APIKEY)
                    .in(SecurityScheme.In.HEADER)));

        return openapi;
    }

}
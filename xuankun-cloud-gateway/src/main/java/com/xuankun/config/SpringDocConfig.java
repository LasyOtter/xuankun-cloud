package com.xuankun.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SwaggerUiConfigParameters;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.ArrayList;
import java.util.List;

/**
 * SpringDoc 配置
 *
 * @author Jimy
 */
@Configuration
public class SpringDocConfig {

    @Bean
    @Lazy(false)
    public List<GroupedOpenApi> apis(SwaggerUiConfigParameters swaggerUiConfigParameters, RouteDefinitionLocator locator) {
        List<GroupedOpenApi> groups = new ArrayList<>();
        List<RouteDefinition> definitions = locator.getRouteDefinitions().collectList().block();
        assert definitions != null;
        definitions.stream().filter(routeDefinition -> !routeDefinition.getId().equals("openapi")).forEach(routeDefinition -> {
            if (routeDefinition.getId().startsWith("ReactiveCompositeDiscoveryClient")) {
                return;
            }
            String name = routeDefinition.getPredicates().get(0).getArgs().values().stream().findFirst().get();
            name = name.replace("/**", "").replace("/", "");
            swaggerUiConfigParameters.addGroup(name);
            GroupedOpenApi.builder().pathsToMatch("/" + name + "/**").group(routeDefinition.getId()).build();
        });
        return groups;
    }


    @Bean
    public OpenAPI customOpenAPI() {
        Contact contact= new Contact();
        contact.setName("Jimy");

        return new OpenAPI().info(new Info()
            .title("XuankunCloud")
            .description( "XuankunCloud")
            .contact(contact)
            .version("1.0")
            .license(new License().name("MIT")));
    }
}
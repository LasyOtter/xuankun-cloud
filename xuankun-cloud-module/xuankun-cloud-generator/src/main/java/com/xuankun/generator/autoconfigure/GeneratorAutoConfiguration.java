package com.xuankun.generator.autoconfigure;

import com.xuankun.generator.config.template.GeneratorConfig;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * spring boot starter AutoConfiguration
 *
 * @author jimy
 * 
 */
@Configuration
@AllArgsConstructor
@ComponentScan(basePackages = {"com.xuankun.generator"})
@EnableConfigurationProperties(GeneratorProperties.class)
public class GeneratorAutoConfiguration {
    private final GeneratorProperties properties;

    @Bean
    GeneratorConfig generatorConfig() {
        return new GeneratorConfig(properties.getTemplate());
    }

}

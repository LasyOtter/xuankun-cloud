package com.xuankun.generator.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * spring boot starter properties
 *
 * @author jimy
 * 
 */
@Data
@ConfigurationProperties("generator")
public class GeneratorProperties {
    /**
     * 模板路径
     */
    private String template = "/template/";
}

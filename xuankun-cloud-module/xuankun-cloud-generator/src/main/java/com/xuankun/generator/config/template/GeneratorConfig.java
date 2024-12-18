package com.xuankun.generator.config.template;

import cn.hutool.core.util.StrUtil;
import com.xuankun.framework.common.exception.ServerException;
import com.xuankun.framework.common.utils.JsonUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * 代码生成配置内容
 *
 * @author jimy
 * 
 */
public class GeneratorConfig {
    private String template;

    public GeneratorConfig(String template) {
        this.template = template;
    }

    public GeneratorInfo getGeneratorConfig() {
        // 模板路径，如果不是以/结尾，则添加/
        if (!StrUtil.endWith(template, '/')) {
            template = template + "/";
        }

        // 模板配置文件
        InputStream isConfig = this.getClass().getResourceAsStream(template + "config.json");
        if (isConfig == null) {
            throw new ServerException("模板配置文件，config.json不存在");
        }

        try {
            // 读取模板配置文件
            String configContent = StreamUtils.copyToString(isConfig, StandardCharsets.UTF_8);
            GeneratorInfo generator = JsonUtils.parseObject(configContent, GeneratorInfo.class);
            for (TemplateInfo templateInfo : generator.getTemplates()) {
                // 模板文件
                InputStream isTemplate = this.getClass().getResourceAsStream(template + templateInfo.getTemplateName());
                if (isTemplate == null) {
                    throw new ServerException("模板文件 " + templateInfo.getTemplateName() + " 不存在");
                }
                // 读取模板内容
                String templateContent = StreamUtils.copyToString(isTemplate, StandardCharsets.UTF_8);

                templateInfo.setTemplateContent(templateContent);
            }
            return generator;
        } catch (IOException e) {
            throw new ServerException("读取config.json配置文件失败");
        }
    }
}

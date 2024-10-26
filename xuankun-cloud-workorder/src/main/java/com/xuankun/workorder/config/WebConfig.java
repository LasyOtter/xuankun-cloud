package com.xuankun.workorder.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * @author Jimy
 * @Title: WebConfig
 * @Package com.xuankun.workorder.config
 * @Description: todo
 * @date 2022/9/15:15:35
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 拦截器跨域配置
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        // 跨域路径
//        CorsRegistration cors = registry.addMapping("/**");
//
//        // 可访问的外部域
//        // 在Springboot2.4对应Spring5.3后在设置allowCredentials(true)的基础上不能直接使用通配符设置allowedOrigins，而是需要指定特定的URL。如果需要设置通配符，需要通过allowedOriginPatterns指定
//        cors.allowedOrigins("*");
//        // 支持跨域用户凭证
//        //cors.allowCredentials(true);
//        // 允许跨域的域名，可以用*表示允许任何域名使用
//        cors.allowedOriginPatterns("*");
//        // 设置 header 能携带的信息
//        cors.allowedHeaders("*");
//        // 支持跨域的请求方法
//        cors.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
//        // 设置跨域过期时间，单位为秒
//        cors.maxAge(3600);
//    }

    // 简写形式
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                //.allowCredentials(true)
                .allowedOriginPatterns("*")
                .allowedHeaders("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
//                 maxAge(3600)表明在3600秒内，不需要再发送预检验请求，可以缓存该结果
                //.exposedHeaders(HttpHeaders.SET_COOKIE).maxAge(3600L);
                .maxAge(3600);
    }
}
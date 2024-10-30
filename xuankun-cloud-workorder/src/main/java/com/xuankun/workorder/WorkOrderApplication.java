package com.xuankun.workorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Jimy
 * @Title: WorkOrderApplication
 * @Package com.xuankun.workorder
 * @Description: todo
 * @date 2022/9/15:9:23
 */
@EnableTransactionManagement
@EnableDiscoveryClient
@SpringBootApplication
public class WorkOrderApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(WorkOrderApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WorkOrderApplication.class);
    }
}

package com.xuankun.workorder.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

/**
 * @author Jimy
 * @Title: JpaQueryConfig
 * @Package com.xuankun.workorder.config
 * @Description: todo
 * @date 2022/9/22:10:33
 */
@Configuration
public class JpaQueryConfig {

    //让Spring管理JPAQueryFactory
    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager){
        return new JPAQueryFactory(entityManager);
    }
}

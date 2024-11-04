package com.xuankun.generator.service;

import com.xuankun.framework.common.page.PageResult;
import com.xuankun.framework.common.query.DbQuery;
import com.xuankun.framework.mybatis.service.BaseService;
import com.xuankun.generator.entity.BaseClassEntity;

import java.util.List;

/**
 * 基类管理
 *
 * @author jimy
 * 
 */
public interface BaseClassService extends BaseService<BaseClassEntity> {

    PageResult<BaseClassEntity> page(DbQuery query);

    List<BaseClassEntity> getList();

    boolean save(BaseClassEntity entity);
}
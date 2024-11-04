package com.xuankun.generator.service;

import com.xuankun.framework.common.page.PageResult;
import com.xuankun.framework.common.query.DbQuery;
import com.xuankun.framework.mybatis.service.BaseService;
import com.xuankun.generator.entity.TableEntity;

/**
 * 数据表
 *
 * @author jimy
 * 
 */
public interface TableService extends BaseService<TableEntity> {

    PageResult<TableEntity> page(DbQuery query);

    TableEntity getByTableName(String tableName);

    void deleteBatchIds(Long[] ids);

    /**
     * 导入表
     *
     * @param datasourceId 数据源ID
     * @param tableName    表名
     */
    void tableImport(Long datasourceId, String tableName);

    /**
     * 同步数据库表
     *
     * @param id 表ID
     */
    void sync(Long id);
}
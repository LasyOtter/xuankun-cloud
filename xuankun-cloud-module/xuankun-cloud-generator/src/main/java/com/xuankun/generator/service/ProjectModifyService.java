package com.xuankun.generator.service;

import com.xuankun.framework.common.page.PageResult;
import com.xuankun.framework.common.query.DbQuery;
import com.xuankun.framework.mybatis.service.BaseService;
import com.xuankun.generator.entity.ProjectModifyEntity;

import java.io.IOException;

/**
 * 项目名变更
 *
 * @author jimy
 * 
 */
public interface ProjectModifyService extends BaseService<ProjectModifyEntity> {

    PageResult<ProjectModifyEntity> page(DbQuery query);

    byte[] download(ProjectModifyEntity project) throws IOException;

}
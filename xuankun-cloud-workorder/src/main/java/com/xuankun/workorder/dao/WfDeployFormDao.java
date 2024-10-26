package com.xuankun.workorder.dao;

import com.xuankun.common.dao.BaseDao;
import com.xuankun.workorder.entity.WfDeployFormEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 流程实例关联表单
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-11
 */
@Mapper
public interface WfDeployFormDao extends BaseDao<WfDeployFormEntity> {
	
}
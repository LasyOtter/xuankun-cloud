package com.xuankun.workorder.dao;

import com.xuankun.common.dao.BaseDao;
import com.xuankun.workorder.entity.WfFormFieldEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 流程表单字段权限表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-19
 */
@Mapper
public interface WfFormFieldDao extends BaseDao<WfFormFieldEntity> {
	
}
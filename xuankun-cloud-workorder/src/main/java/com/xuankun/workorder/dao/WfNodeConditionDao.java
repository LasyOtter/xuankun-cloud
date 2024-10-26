package com.xuankun.workorder.dao;

import com.xuankun.common.dao.BaseDao;
import com.xuankun.workorder.entity.WfNodeConditionEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-11
 */
@Mapper
public interface WfNodeConditionDao extends BaseDao<WfNodeConditionEntity> {

    void deletNodeConditionByFormId(Long formId);
}
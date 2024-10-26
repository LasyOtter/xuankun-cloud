package com.xuankun.workorder.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xuankun.common.dao.BaseDao;
import com.xuankun.workorder.entity.OperationSchemeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-09-15
 */
@Mapper
public interface OperationSchemeDao extends BaseDao<OperationSchemeEntity> {
    IPage<OperationSchemeEntity> findPage(IPage<OperationSchemeEntity> page, @Param("ew") Wrapper<OperationSchemeEntity> queryWrapper);
}
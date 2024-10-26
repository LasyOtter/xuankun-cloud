package com.xuankun.workorder.dao;

import com.xuankun.common.dao.BaseDao;
import com.xuankun.common.utils.Result;
import com.xuankun.workorder.dto.WfFormDTO;
import com.xuankun.workorder.entity.WfFormEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 流程表单信息表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-11
 */
@Mapper
public interface WfFormDao extends BaseDao<WfFormEntity> {

    List<WfFormDTO> getFormListByUserId(@Param("userIds") List<Integer> userIds,@Param("roleIds") List<Integer> roleIds);
}
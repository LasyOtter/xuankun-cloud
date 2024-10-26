package com.xuankun.workorder.dao;

import com.xuankun.common.dao.BaseDao;
import com.xuankun.workorder.entity.WfFormUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 表单发起用户表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-20
 */
@Mapper
public interface WfFormUserDao extends BaseDao<WfFormUserEntity> {

    @Select("delete from wf_form_user where form_id=#{formId}")
    void deleteFormUserByFormId(@Param("formId") long formId);
}
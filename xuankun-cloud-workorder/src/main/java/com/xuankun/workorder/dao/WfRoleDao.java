package com.xuankun.workorder.dao;

import com.xuankun.common.dao.BaseDao;
import com.xuankun.workorder.dto.RoleDTO;
import com.xuankun.workorder.dto.WfRoleDTO;
import com.xuankun.workorder.entity.WfRoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 角色表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-31
 */
@Mapper
public interface WfRoleDao extends BaseDao<WfRoleEntity> {

    @Select("select id as role_id,role_name FROM wf_role where del_flag=0")
    List<RoleDTO> getAllRoleName();

    @Select("select id FROM wf_role where role_name=#{roleName} and del_flag=0")
    int getIdByRoleName(String roleName);

    @Select("select * FROM wf_role where role_name=#{roleName} and del_flag=0")
    WfRoleDTO getOneByRoleName(String roleName);

    @Select("select role_name FROM wf_role where id=#{roleId} and del_flag=0")
    String getRoleNameByRoleId(int roleId);
}
package com.xuankun.workorder.service;

import com.xuankun.common.service.CrudService;
import com.xuankun.workorder.dto.RoleDTO;
import com.xuankun.workorder.dto.WfRoleDTO;
import com.xuankun.workorder.entity.WfRoleEntity;

import java.util.List;

/**
 * 角色表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-31
 */
public interface WfRoleService extends CrudService<WfRoleEntity, WfRoleDTO> {
    List<RoleDTO> getAllRoleName();

    int getIdByRoleName(String roleName);

    WfRoleDTO getOneByRoleName(String roleName);

    String getRoleNameByRoleId(int roleId);
}
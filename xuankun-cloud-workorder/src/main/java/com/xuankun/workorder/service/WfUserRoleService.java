package com.xuankun.workorder.service;

import com.xuankun.common.service.CrudService;
import com.xuankun.workorder.dto.*;
import com.xuankun.workorder.entity.WfUserRoleEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户权限表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-11-07
 */
public interface WfUserRoleService extends CrudService<WfUserRoleEntity, WfUserRoleDTO> {

    List<Map<String,Object>> getRegionUserNames(List<String> roleNameList,int orgId);

    List<Map<String,Object>> getRegionUserIds(List<String> roleNameList,int orgId);

    RegionUserRoleDTO getRegionUserRoleInfo(int orgId);

    WfUserRoleDTO saveRegionUserRole(SaveRegionUserRoleDTO dto);

    WfUserRoleDTO getUserRoleByRegionIdAndRoleAndUserId(int regionId,int roleId);

    int deleteByRegionIdAndRoleAndUserId(SaveRegionUserRoleDTO dto);

    UserDTO getUserInfoByRegionIdAndRoleAndUserId(int regionId, int roleId);
    /**
     * 根据用户信息取用户角色
     * @param userId
     * @param orgId
     * @return 用户角色
     */
    List<RoleDTO> getRoleByUserIdAndOrgId(int userId, int orgId);
}
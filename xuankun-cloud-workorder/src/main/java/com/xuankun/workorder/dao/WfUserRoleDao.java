package com.xuankun.workorder.dao;

import com.xuankun.common.dao.BaseDao;
import com.xuankun.workorder.dto.RoleDTO;
import com.xuankun.workorder.dto.UserDTO;
import com.xuankun.workorder.dto.WfUserRoleDTO;
import com.xuankun.workorder.entity.WfUserRoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 用户权限表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-11-07
 */
@Mapper
public interface WfUserRoleDao extends BaseDao<WfUserRoleEntity> {

    List<Map<String,Object>> getRegionUserNames(List<String> list,int orgId);

    List<Map<String,Object>> getRegionUserIds(List<String> list,int orgId);

    @Select("select * from wf_user_role where region_id=#{regionId} and role_id=#{roleId} and del_flag=0 limit 1")
    WfUserRoleDTO getUserRoleByRegionIdAndRoleAndUserId(int regionId, int roleId);

    @Select("select user_id,user_name from wf_user_role where region_id=#{regionId} and role_id=#{roleId} and del_flag=0 limit 1")
    UserDTO getUserInfoByRegionIdAndRoleAndUserId(int regionId, int roleId);

    /**
     * 根据用户信息取用户角色
     * @param userId
     * @param orgId
     * @return 用户角色
     */
    @Select("select  t1.role_id as roleId,t2.role_name as roleName from wf_user_role t1 " +
            "INNER JOIN wf_role t2 on t1.role_id=t2.id INNER JOIN wf_org_region t4 on t4.region_id=t1.region_id " +
            "where t1.user_id=#{userId} and t4.org_id=#{orgId} and t1.del_flag=0 and t2.del_flag=0 ")
    List<RoleDTO> getRoleByUserIdAndOrgId(int userId,int orgId);
}
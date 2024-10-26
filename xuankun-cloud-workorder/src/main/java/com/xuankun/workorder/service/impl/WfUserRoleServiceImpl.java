package com.xuankun.workorder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xuankun.common.service.impl.CrudServiceImpl;
import com.xuankun.workorder.dao.WfUserRoleDao;
import com.xuankun.workorder.dto.*;
import com.xuankun.workorder.entity.WfUserRoleEntity;
import com.xuankun.workorder.service.WfRoleService;
import com.xuankun.workorder.service.WfUserRoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 用户权限表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-11-07
 */
@Service
public class WfUserRoleServiceImpl extends CrudServiceImpl<WfUserRoleDao, WfUserRoleEntity, WfUserRoleDTO> implements WfUserRoleService {

    @Resource
    private WfRoleService roleService;

    @Override
    public QueryWrapper<WfUserRoleEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");
        QueryWrapper<WfUserRoleEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);
        return wrapper;
    }


    @Override
    public List<Map<String, Object>> getRegionUserNames(List<String> roleNameList,int orgId) {
        return this.baseDao.getRegionUserNames(roleNameList,orgId);
    }

    @Override
    public List<Map<String, Object>> getRegionUserIds(List<String> roleNameList,int orgId) {
        return this.baseDao.getRegionUserIds(roleNameList,orgId);
    }

    @Override
    public RegionUserRoleDTO getRegionUserRoleInfo(int orgId) {
        RegionUserRoleDTO regionUserRoleDTO = new RegionUserRoleDTO();
        List<RoleDTO> roleList = roleService.getAllRoleName();
        if(roleList == null || roleList.isEmpty()){
            return regionUserRoleDTO;
        }
        List<String> roleNameList = new ArrayList<>();
        for (RoleDTO dto:roleList){
            roleNameList.add(dto.getRoleName());
        }
        if(roleList == null && roleList.isEmpty()){
            return regionUserRoleDTO;
        }else {
            List<Map<String, Object>> userNameList = this.baseDao.getRegionUserNames(roleNameList,orgId);
            List<Map<String, Object>> userIdList = this.baseDao.getRegionUserIds(roleNameList,orgId);
            regionUserRoleDTO.setRoleList(roleList);
            regionUserRoleDTO.setUserNameList(userNameList);
            regionUserRoleDTO.setUserIdList(userIdList);
        }
        return regionUserRoleDTO;
    }

    @Override
    public WfUserRoleDTO saveRegionUserRole(SaveRegionUserRoleDTO dto) {
        int roleId = dto.getRoleDTO().getRoleId();
        WfUserRoleDTO userRoleDTO = getUserRoleByRegionIdAndRoleAndUserId(dto.getRegionId(),roleId);
        if(userRoleDTO != null){
            userRoleDTO.setUserId(dto.getUserId());
            this.update(userRoleDTO);
            return userRoleDTO;
        }
        userRoleDTO = new WfUserRoleDTO();
        userRoleDTO.setRoleId(roleId);
        userRoleDTO.setRegionId(dto.getRegionId());
        userRoleDTO.setUserId(dto.getUserId());
        userRoleDTO.setOrgId(dto.getOrgId());
        this.save(userRoleDTO);
        return userRoleDTO;
    }

    @Override
    public WfUserRoleDTO getUserRoleByRegionIdAndRoleAndUserId(int regionId, int roleId) {
        return this.baseDao.getUserRoleByRegionIdAndRoleAndUserId(regionId, roleId);
    }

    @Override
    public int deleteByRegionIdAndRoleAndUserId(SaveRegionUserRoleDTO dto) {
        int roleId = dto.getRoleDTO().getRoleId();
        QueryWrapper<WfUserRoleEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("region_id",dto.getRegionId());
        wrapper.eq("role_id",roleId);
        wrapper.eq("user_id",dto.getUserId());
        return this.baseDao.delete(wrapper);
    }

    @Override
    public UserDTO getUserInfoByRegionIdAndRoleAndUserId(int regionId, int roleId) {
        return this.baseDao.getUserInfoByRegionIdAndRoleAndUserId(regionId, roleId);
    }

    @Override
    public List<RoleDTO> getRoleByUserIdAndOrgId(int userId, int orgId) {
        return this.baseDao.getRoleByUserIdAndOrgId(userId, orgId);
    }
}
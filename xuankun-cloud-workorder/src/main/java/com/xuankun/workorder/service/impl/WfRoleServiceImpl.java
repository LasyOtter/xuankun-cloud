package com.xuankun.workorder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xuankun.common.service.impl.CrudServiceImpl;
import com.xuankun.workorder.dao.WfRoleDao;
import com.xuankun.workorder.dto.RoleDTO;
import com.xuankun.workorder.dto.WfRoleDTO;
import com.xuankun.workorder.entity.WfRoleEntity;
import com.xuankun.workorder.service.WfRoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 角色表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-31
 */
@Service
public class WfRoleServiceImpl extends CrudServiceImpl<WfRoleDao, WfRoleEntity, WfRoleDTO> implements WfRoleService {

    @Override
    public QueryWrapper<WfRoleEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");
        String roleName = (String)params.get("roleName");

        QueryWrapper<WfRoleEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);
        wrapper.eq(StringUtils.isNotBlank(id), "role_name", roleName);

        return wrapper;
    }


    @Override
    public List<RoleDTO> getAllRoleName() {
        return this.baseDao.getAllRoleName();
    }

    @Override
    public int getIdByRoleName(String roleName) {
        return this.baseDao.getIdByRoleName(roleName);
    }

    @Override
    public WfRoleDTO getOneByRoleName(String roleName) {
        return this.baseDao.getOneByRoleName(roleName);
    }

    @Override
    public String getRoleNameByRoleId(int roleId) {
        return this.baseDao.getRoleNameByRoleId(roleId);
    }
}
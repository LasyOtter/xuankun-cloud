package com.xuankun.workorder.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xuankun.common.page.PageData;
import com.xuankun.common.service.impl.CrudServiceImpl;
import com.xuankun.common.utils.ConvertUtils;
import com.xuankun.workorder.dao.WfDeptUserDao;
import com.xuankun.workorder.dto.UserDTO;
import com.xuankun.workorder.dto.WfDeptUserDTO;
import com.xuankun.workorder.entity.WfDeptUserEntity;
import com.xuankun.workorder.service.WfDeptUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 部门与用户对照表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-11-07
 */
@Service
public class WfDeptUserServiceImpl extends CrudServiceImpl<WfDeptUserDao, WfDeptUserEntity, WfDeptUserDTO> implements WfDeptUserService {

    @Override
    public QueryWrapper<WfDeptUserEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");
        String deptId = (String)params.get("deptId");
        String userId = (String)params.get("userId");
        String regionId = (String)params.get("regionId");
        QueryWrapper<WfDeptUserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);
        wrapper.eq(StringUtils.isNotBlank(deptId), "dept_id", deptId);
        wrapper.eq(StringUtils.isNotBlank(userId), "user_id", userId);
        wrapper.eq(StringUtils.isNotBlank(regionId), "region_id", regionId);
        return wrapper;
    }


    @Override
    public UserDTO getLeaderByUserId(int userId) {
        return this.baseDao.getLeaderByUserId(userId);
    }

    @Override
    public List<UserDTO> getMultiUserByUserId(int userId, int count) {
        List<UserDTO> userList = new ArrayList<>();
        if(count == 0){
            return userList;
        }
        //examineEndDirectorLevel为1时表示最高级部门主管
        if(count == 1){
            UserDTO dto = this.baseDao.getLeaderByUserId(userId);
            userList.add(dto);
            while(dto  != null){
                dto = this.baseDao.getLeaderByUserId(userId);
                if (dto != null) {
                    userId = dto.getUserId();
                    userList.add(dto);
                }
            }
            return userList;
        }
        while(count > 0){
            UserDTO dto = this.baseDao.getLeaderByUserId(userId);
            if(dto != null){
                userId = dto.getUserId();
                userList.add(dto);
            }
            count --;
        }
        return userList;
    }

    @Override
    public List<UserDTO> getRegionUserByRegionId(int regionId) {
        return this.baseDao.getRegionUserByRegionId(regionId);
    }

    @Override
    public PageData<WfDeptUserDTO> getDeptUserList(Map<String, Object> params) {
        IPage<WfDeptUserEntity> page = Page.of(Long.parseLong(params.get("page").toString()) ,Long.parseLong(params.get("limit").toString()));
        QueryWrapper<WfDeptUserEntity> queryWrapper = this.getDtoWrapper(params);
        return this.getPageData(this.baseDao.getDeptUserList(page, queryWrapper), WfDeptUserDTO.class);
    }

    @Override
    public List<WfDeptUserDTO> getAllDeptUserList(Map<String, Object> params) {
        List<WfDeptUserDTO> userDTOS = new ArrayList<>();
        QueryWrapper<WfDeptUserEntity> queryWrapper = this.getDtoWrapper(params);
        List<WfDeptUserEntity> userEntities = this.baseDao.getAllDeptUserList(queryWrapper);
        userDTOS = ConvertUtils.sourceToTarget(userEntities,WfDeptUserDTO.class);
        return userDTOS;
    }

    @Override
    public Integer getUserOrgIdByUserId(int userId) {
        return this.baseDao.getUserOrgIdByUserId(userId);
    }

    private QueryWrapper<WfDeptUserEntity> getDtoWrapper(Map<String, Object> params) {
        QueryWrapper<WfDeptUserEntity> wrapper = new QueryWrapper<>();
        if (params == null) {
            wrapper.eq("t1.del_flag",0);
            wrapper.eq("t2.del_flag",0);
        }else{
            String id = (String)params.get("id");
            String deptId = (String)params.get("deptId");
            String userId = (String)params.get("userId");
            String orgId = (String)params.get("orgId");

            wrapper.eq("t1.del_flag",0);
            wrapper.eq("t2.del_flag",0);
            wrapper.eq(StringUtils.isNotBlank(id), "t1.id", id);
            wrapper.eq(StringUtils.isNotBlank(deptId), "t1.dept_id", deptId);
            wrapper.eq(StringUtils.isNotBlank(userId), "t1.user_id", userId);
            wrapper.eq(StringUtils.isNotBlank(orgId), "t2.tenant_id", orgId);
        }
        return wrapper;
    }
}
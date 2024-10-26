package com.xuankun.workorder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xuankun.common.page.PageData;
import com.xuankun.common.service.impl.CrudServiceImpl;
import com.xuankun.workorder.dao.WfUserSuperiorDao;
import com.xuankun.workorder.dto.UserDTO;
import com.xuankun.workorder.dto.UserSuperiorDTO;
import com.xuankun.workorder.dto.WfUserSuperiorDTO;
import com.xuankun.workorder.entity.WfUserSuperiorEntity;
import com.xuankun.workorder.service.WfUserSuperiorService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-11-15
 */
@Service
public class WfUserSuperiorServiceImpl extends CrudServiceImpl<WfUserSuperiorDao, WfUserSuperiorEntity, WfUserSuperiorDTO> implements WfUserSuperiorService {

    @Override
    public QueryWrapper<WfUserSuperiorEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");
        String userId = (String)params.get("userId");
        String parentUserId = (String)params.get("parentUserId");
        String orgId = (String)params.get("orgId");

        QueryWrapper<WfUserSuperiorEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);
        wrapper.eq(StringUtils.isNotBlank(userId), "user_id", userId);
        wrapper.eq(StringUtils.isNotBlank(parentUserId), "parent_user_id", parentUserId);
        wrapper.eq(StringUtils.isNotBlank(orgId), "org_id", orgId);
        return wrapper;
    }

    private QueryWrapper<WfUserSuperiorEntity> getDtoWrapper(Map<String, Object> params){
        QueryWrapper<WfUserSuperiorEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("t1.del_flag",0);
        wrapper.notExists("select 1 from wf_user_superior where parent_user_id = t1.user_id",0);
        if(params == null){
            return wrapper;
        }
        String id = (String)params.get("id");
        String userId = (String)params.get("userId");
        String parentUserId = (String)params.get("parentUserId");
        String orgId = (String)params.get("orgId");
        String userName = (String)params.get("userName");
        String parentUserName = (String)params.get("parentUserName");
        String orgName = (String)params.get("orgName");

        wrapper.eq(StringUtils.isNotBlank(id), "t1.id", id);
        wrapper.eq(StringUtils.isNotBlank(userId), "t1.user_id", userId);
        wrapper.eq(StringUtils.isNotBlank(parentUserId), "t1.parent_user_id", parentUserId);
        wrapper.eq(StringUtils.isNotBlank(orgId), "t1.org_id", orgId);
        wrapper.like(StringUtils.isNotBlank(userName), "t2.name", userName);
        wrapper.like(StringUtils.isNotBlank(parentUserName), "t3.name", parentUserName);
        wrapper.like(StringUtils.isNotBlank(orgName), "t4.name", orgName);
        return wrapper;
    }

    @Override
    public PageData<UserSuperiorDTO> getAllUserSuperiorInfo(Map<String, Object> params) {
        IPage<WfUserSuperiorEntity> page = Page.of(Long.parseLong(params.get("page").toString()) ,Long.parseLong(params.get("limit").toString()));
        return this.getPageData(this.baseDao.getAllUserSuperiorInfo(page,this.getDtoWrapper(params)),UserSuperiorDTO.class);
    }

    @Override
    public UserDTO getSuperiorUserByUserId(int userId, int orgId) {
        return this.baseDao.getSuperiorUserByUserId(userId, orgId);
    }

    @Override
    public List<UserDTO> getSuperiorUserByUserId(int userId, int orgId, int step) {
        List<UserDTO> userList = new ArrayList<>();
        if(step == 0){
            return userList;
        }
        //examineEndDirectorLevel为1时表示最高级主管
        if(step == 1){
            List<UserDTO> dto = this.baseDao.getSuperiorUserListByUserId(userId, orgId);
            while(dto  != null){
                dto = this.baseDao.getSuperiorUserListByUserId(userId, orgId);
                if (dto != null && !dto.isEmpty()) {
                    for(UserDTO userDTO:dto){
                        if (userDTO != null) {
                            userId = userDTO.getUserId();
                        }
                    }
                    userList.addAll(dto);
                }
            }
            return userList;
        }
        while(step > 0){
            List<UserDTO> dto = this.baseDao.getSuperiorUserListByUserId(userId, orgId);
            if (dto != null && !dto.isEmpty()) {
                for(UserDTO userDTO:dto){
                    if (userDTO != null) {
                        userId = userDTO.getUserId();
                    }
                }
                userList.addAll(dto);
            }
            step --;
        }
        return userList;
    }

    @Override
    public List<UserSuperiorDTO> getParentUserInfo(int userId) {
        List<Integer> userIdList = new ArrayList<>();
        userIdList.add(userId);
        List<Integer> userList = getParentIdListByUserId(userId);
//        if (userList != null && !userList.isEmpty()) {
//            userIdList.addAll(userList);
//            List<Integer> list = new ArrayList<>();
//            for(Integer id:userList){
//                list = getParentIdListByUserId(id);
//                if (list != null && !list.isEmpty()) {
//                    userIdList.addAll(list);
//                }
//            }
//        }
        return this.baseDao.getParentUserInfo(userIdList);
    }

    @Override
    public List<UserDTO> getChildUserInfo(int parentUserId) {
        List<UserDTO> userList = new ArrayList<>();
        UserDTO dto = this.baseDao.getChildUserInfo(parentUserId);
        if (dto != null) {
            userList.add(dto);
        }
        while(dto != null){
            parentUserId = dto.getUserId();
            dto = this.baseDao.getChildUserInfo(parentUserId);
            if (dto != null) {
                userList.add(dto);
            }
        }
        return userList;
    }

    @Override
    public List<Integer> getParentIdListByUserId(int userId) {
        return this.baseDao.getParentIdListByUserId(userId);
    }
}
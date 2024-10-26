package com.xuankun.workorder.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.xuankun.common.page.PageData;
import com.xuankun.common.service.CrudService;
import com.xuankun.workorder.dto.UserDTO;
import com.xuankun.workorder.dto.UserSuperiorDTO;
import com.xuankun.workorder.dto.WfUserSuperiorDTO;
import com.xuankun.workorder.entity.WfUserSuperiorEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-11-15
 */
public interface WfUserSuperiorService extends CrudService<WfUserSuperiorEntity, WfUserSuperiorDTO> {
    PageData<UserSuperiorDTO> getAllUserSuperiorInfo(Map<String, Object> params);

    UserDTO getSuperiorUserByUserId(int userId, int orgId);

    List<UserDTO> getSuperiorUserByUserId(int userId, int orgId,int step);

    List<UserSuperiorDTO> getParentUserInfo(int userId);

    List<UserDTO> getChildUserInfo(int parentUserId);

    List<Integer> getParentIdListByUserId(int userId);
}
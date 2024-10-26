package com.xuankun.workorder.service;

import com.xuankun.common.page.PageData;
import com.xuankun.common.service.CrudService;
import com.xuankun.workorder.dto.UserDTO;
import com.xuankun.workorder.dto.WfDeptUserDTO;
import com.xuankun.workorder.dto.WorkOrderDTO;
import com.xuankun.workorder.entity.WfDeptUserEntity;

import java.util.List;
import java.util.Map;

/**
 * 部门与用户对照表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-11-07
 */
public interface WfDeptUserService extends CrudService<WfDeptUserEntity, WfDeptUserDTO> {

    /**
     * 根据用户ID获取部门上级
     * @param userId
     * @return
     */
    UserDTO getLeaderByUserId(int userId);

    /**
     * 根据用户ID获取多级部门上级
     * @param userId
     * @param count
     * @return
     */
    List<UserDTO> getMultiUserByUserId(int userId, int count);

    /**
     * 根据用户ID获取表单内区域控件对应审批人
     * @param regionId
     * @return
     */
    List<UserDTO> getRegionUserByRegionId(int regionId);

    PageData<WfDeptUserDTO> getDeptUserList(Map<String, Object> params);

    List<WfDeptUserDTO> getAllDeptUserList(Map<String, Object> params);
    /**
     * 根据用户ID获取组织ID
     * @param userId
     * @return
     */
    Integer getUserOrgIdByUserId(int userId);
}
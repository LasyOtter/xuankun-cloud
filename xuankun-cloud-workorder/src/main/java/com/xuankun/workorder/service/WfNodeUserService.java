package com.xuankun.workorder.service;

import com.xuankun.common.service.CrudService;
import com.xuankun.workorder.dto.UserDTO;
import com.xuankun.workorder.dto.WfNodeUserDTO;
import com.xuankun.workorder.entity.WfNodeUserEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-11
 */
public interface WfNodeUserService extends CrudService<WfNodeUserEntity, WfNodeUserDTO> {
    List<WfNodeUserEntity> getNodeUserInfo(int orderId,long formId,List<String> roleName);

    List<WfNodeUserEntity> getNodeUserInfoByFormIdAndRoleIds(int orderId,long formId,int roleId);

    List<WfNodeUserEntity> getNodeUserInfoByFormId(long formId);

    void deletNodeUserByFormId(Long formId);

    List<WfNodeUserEntity> getNodeUserByNodeIdAndFormId(int nodeId,Long formId);

    List<WfNodeUserEntity> getMinNodeUserInfoByFormId(long formId,int roleId,int userId);

    List<WfNodeUserEntity> getNodeUserInfoByParentId(long parentId);

    List<WfNodeUserEntity> getNodeUserInfoByFormIdAndRoleId(long formId,int roleId,int userId);

    List<UserDTO> getUserInfoByRoleId(int roleId);

    WfNodeUserEntity queryStartNodeUserByNodeId(int nodeId,int userType,int roleId);

    List<WfNodeUserEntity> queryApprovalNodeUserByParentNodeId(int parentNodeId);

    WfNodeUserEntity queryStartNodeUserByParentNodeId(int nodeId,int userType,int roleId);
}
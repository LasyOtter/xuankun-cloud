package com.xuankun.workorder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.xuankun.common.service.impl.CrudServiceImpl;
import com.xuankun.workorder.dto.UserDTO;
import com.xuankun.workorder.service.WfNodeUserService;
import com.xuankun.workorder.dao.WfNodeUserDao;
import com.xuankun.workorder.dto.WfNodeUserDTO;
import com.xuankun.workorder.entity.QWfNodeUserEntity;
import com.xuankun.workorder.entity.WfNodeUserEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-11
 */
@Service
public class WfNodeUserServiceImpl extends CrudServiceImpl<WfNodeUserDao, WfNodeUserEntity, WfNodeUserDTO> implements WfNodeUserService {

    @Resource
    private JPAQueryFactory queryFactory;

    @Override
    public QueryWrapper<WfNodeUserEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");
        Long formId = (Long) params.get("formId");

        QueryWrapper<WfNodeUserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);
        wrapper.eq(formId != null, "form_id", formId);

        return wrapper;
    }


    @Override
    public List<WfNodeUserEntity> getNodeUserInfo(int orderId,long formId,List<String> roleName) {
        QueryWrapper<WfNodeUserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("form_id",formId);
        queryWrapper.in("role_name",roleName);
        queryWrapper.exists(orderId > 0,"select * from t_work_order o where form_id=o.form_id and o.id={0}",orderId);
        return this.baseDao.selectList(queryWrapper);
    }

    @Override
    public List<WfNodeUserEntity> getNodeUserInfoByFormIdAndRoleIds(int orderId,long formId, int roleId) {
        return this.baseDao.getNodeUserInfoByFormIdAndRoleIds(orderId, formId, roleId);
    }

    @Override
    public List<WfNodeUserEntity> getNodeUserInfoByFormId(long formId) {
        return this.baseDao.getNodeUserInfoByFormId(formId);
    }

    @Transactional(rollbackFor = {Exception.class}) //注解声明事务捕获到异常回滚
    @Override
    public void deletNodeUserByFormId(Long formId) {
        Map<String, Object> params = new HashMap<>();
        params.put("formId",formId);
        this.baseDao.delete(getWrapper(params));
    }

    @Override
    public List<WfNodeUserEntity> getNodeUserByNodeIdAndFormId(int nodeId, Long formId) {
        QWfNodeUserEntity nodeUserEntity = QWfNodeUserEntity.wfNodeUserEntity;
        List<WfNodeUserEntity> nodeUserList = queryFactory.select(nodeUserEntity).from(nodeUserEntity).where(nodeUserEntity.formId.eq(formId).and(nodeUserEntity.nodeId.eq(nodeId))).fetch();
        return nodeUserList;
    }


    @Override
    public List<WfNodeUserEntity> getMinNodeUserInfoByFormId(long formId,int roleId,int userId) {
        List<WfNodeUserEntity> nodeUserList = this.baseDao.getApplyNodeUserInfo(formId,roleId,userId);
        if (nodeUserList == null || nodeUserList.isEmpty()) {
            nodeUserList =  this.baseDao.getApplyNodeUserInfoInCondition(formId,roleId,userId);
            if (nodeUserList == null || nodeUserList.isEmpty()) {
                return this.baseDao.getNodeUserInfoByFormIdAndType(formId);
            }
        }
        return nodeUserList;
    }

    @Override
    public List<WfNodeUserEntity> getNodeUserInfoByParentId(long parentId) {
        return this.baseDao.getNodeUserInfoByParentId(parentId);
    }

    @Override
    public List<WfNodeUserEntity> getNodeUserInfoByFormIdAndRoleId(long formId, int roleId,int userId) {
        List<WfNodeUserEntity> nodeUserList = this.baseDao.getNodeUserInfoByFormIdAndRoleId(formId,roleId,userId);
//        if (nodeUserList == null || nodeUserList.isEmpty()) {
//            nodeUserList = this.baseDao.getApprovalNodeUserInfoByFormId(formId);
//        }
        return nodeUserList;
    }

    @Override
    public List<UserDTO> getUserInfoByRoleId(int roleId) {
        return this.baseDao.getUserInfoByRoleId(roleId);
    }

    @Override
    public WfNodeUserEntity queryStartNodeUserByNodeId(int nodeId, int userType, int roleId) {
        return this.baseDao.queryStartNodeUserByNodeId(nodeId, userType, roleId);
    }

    @Override
    public List<WfNodeUserEntity> queryApprovalNodeUserByParentNodeId(int parentNodeId) {
        return this.baseDao.queryApprovalNodeUserByParentNodeId(parentNodeId);
    }

    @Override
    public WfNodeUserEntity queryStartNodeUserByParentNodeId(int nodeId, int userType, int roleId) {
        return this.baseDao.queryStartNodeUserByParentNodeId(nodeId, userType, roleId);
    }
}
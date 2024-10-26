package com.xuankun.workorder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.xuankun.common.service.impl.CrudServiceImpl;
import com.xuankun.workorder.dao.WfProcessUserApprovalDao;
import com.xuankun.workorder.dto.ProcessUserApprovalListDTO;
import com.xuankun.workorder.dto.WfProcessUserApprovalDTO;
import com.xuankun.workorder.entity.QWfProcessUserApprovalEntity;
import com.xuankun.workorder.entity.WfProcessUserApprovalEntity;
import com.xuankun.workorder.service.WfProcessUserApprovalService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-12
 */
@Service
public class WfProcessUserApprovalServiceImpl extends CrudServiceImpl<WfProcessUserApprovalDao, WfProcessUserApprovalEntity, WfProcessUserApprovalDTO> implements WfProcessUserApprovalService {
    @Resource
    private JPAQueryFactory queryFactory;

    @Override
    public QueryWrapper<WfProcessUserApprovalEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<WfProcessUserApprovalEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


    @Override
    public WfProcessUserApprovalEntity getApproveByOrderIdAndNodeId(int orderId, int nodeId) {
        return this.baseDao.getApproveByOrderIdAndNodeId(orderId,nodeId);
    }

    @Override
    public WfProcessUserApprovalEntity getOldApprove(int orderId, List<String> roleName) {
        QueryWrapper<WfProcessUserApprovalEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(orderId>0,"order_id",orderId);
        wrapper.in(roleName != null && roleName.size() > 0, "role_name",roleName);
        List<WfProcessUserApprovalEntity> approvalEntities = this.baseDao.selectList(wrapper);
        if(approvalEntities != null && approvalEntities.size() > 0){
            return approvalEntities.get(0);
        }
        return null;
    }

    @Override
    public WfProcessUserApprovalEntity getApprovalByOrderIdAndRoleId(int orderId, List<Integer> roleId, int userId) {
        QueryWrapper<WfProcessUserApprovalEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(orderId>0,"order_id",orderId);
        wrapper.eq(orderId>0,"is_approval",0);
        wrapper.and(queryWrapper->queryWrapper.in(roleId != null && roleId.size()  > 0, "role_id",roleId)
                .or().eq("role_id",userId));
        List<WfProcessUserApprovalEntity> approvalEntities = this.baseDao.selectList(wrapper);
        if(approvalEntities != null && approvalEntities.size() > 0){
            return approvalEntities.get(0);
        }
        return null;
    }

    @Override
    public List<ProcessUserApprovalListDTO> getApproveListByOrderId(int orderId) {
        return this.baseDao.getApproveListByOrderId(orderId);
    }

    @Override
    public WfProcessUserApprovalEntity getNodeApprovalInfoByParentNodedId(int parentNodeId, int orderId, long formId) {
        return this.baseDao.getNodeApprovalInfoByParentNodedId(parentNodeId, orderId, formId);
    }

    @Override
    public int countProcessNodeByNodeIdAndIsApproval(int orderId,int nodeId, int isApproval) {
        return this.baseDao.countProcessNodeByNodeIdAndIsApproval(orderId,nodeId, isApproval);
    }

    @Override
    public Long updateApprovalById(WfProcessUserApprovalEntity entity) {
        QWfProcessUserApprovalEntity approvalEntity = QWfProcessUserApprovalEntity.wfProcessUserApprovalEntity;

        return queryFactory.update(approvalEntity)
                .set(approvalEntity.isApproval,entity.getIsApproval())
                .set(approvalEntity.approvalState,entity.getApprovalState())
                .set(approvalEntity.approvalType,entity.getApprovalType())
                .set(approvalEntity.remark,entity.getRemark())
                .set(approvalEntity.userId,entity.getUserId())
                .where(approvalEntity.id.eq(entity.getId()).and(approvalEntity.delFlag.eq(0))).execute();
    }

    @Override
    public void deleteApproveByParentNodeIdIdAndNodeId(int parentNodeId, int nodeId,int orderId) {
        this.baseDao.deleteApproveByParentNodeIdIdAndNodeId(parentNodeId, nodeId,orderId);
    }

}
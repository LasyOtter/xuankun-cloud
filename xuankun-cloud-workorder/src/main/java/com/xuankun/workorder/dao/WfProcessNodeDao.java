package com.xuankun.workorder.dao;

import com.xuankun.common.dao.BaseDao;
import com.xuankun.workorder.dto.PorcessNodeFlowInfoDTO;
import com.xuankun.workorder.entity.WfNodeUserEntity;
import com.xuankun.workorder.entity.WfProcessNodeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-11
 */
@Mapper
public interface WfProcessNodeDao extends BaseDao<WfProcessNodeEntity> {

    void deletNodeByCodeAndFormId(String nodeCode, Long formId);

    void deletNodeByProcessIdAndFormId(Long processId, Long formId);

    @Select("select t1.node_code as nodeCode,t2.is_approval as isApproval from " +
            "wf_process_user_approval t2 INNER JOIN wf_process_node t1 on t1.form_id=t2.form_id and t1.id=t2.node_id " +
            "where t2.order_id=#{orderId} ")
    List<PorcessNodeFlowInfoDTO> getNodeFlowInfo(@Param("orderId") int orderId);

    @Select("select t2.* from wf_process_node t1 INNER JOIN wf_node_user t2 on t1.id=t2.node_id " +
            "where t1.form_id=#{formId} and t1.type=0 and t2.role_id=0 and t1.del_flag=0 and t2.del_flag=0 limit 1")
    WfNodeUserEntity queryAllStartProcessNodeIdByFormId(Long formId);

    @Select("select count(*) from wf_process_node t1 INNER JOIN wf_node_user t2 on t1.id=t2.node_id where t1.form_id=#{formId} " +
            "and t1.parent_id=#{parentNodeId} and t1.is_condition_node=#{isConditionNode} and t1.del_flag=0 and t2.del_flag=0 ")
    int countNodeByFormIdAndParentId(Long formId,int parentNodeId,int isConditionNode);

    @Select("select t2.* from wf_process_node t1 INNER JOIN wf_node_user t2 on t1.id=t2.node_id " +
            "where t1.form_id=#{formId} and t1.type=3 and t2.type=#{userType} and t2.role_id=#{roleId} and t1.parent_id=#{parentNodeId} " +
            "and t1.is_condition_node=#{isConditionNode} and t1.del_flag=0 and t2.del_flag=0 ")
    WfNodeUserEntity queryApplyNodeUserByFormIdAndRoleAndParentId(Long formId,int userType,int roleId,int parentNodeId,int isConditionNode);

    @Select("select t2.* from wf_process_node t1 INNER JOIN wf_node_user t2 on t1.id=t2.node_id " +
            "where t1.form_id=#{formId} and t1.type=0 and t2.type=#{userType} and t2.role_id=#{roleId} and t1.id=#{nodeId} " +
            "and t1.is_condition_node=#{isConditionNode} and t1.del_flag=0 and t2.del_flag=0 ")
    WfNodeUserEntity queryApplyNodeUserByFormIdAndRoleAndNodeId(Long formId,int userType,int roleId,int nodeId,int isConditionNode);

    @Select("select t2.* from wf_process_node t1 INNER JOIN wf_node_user t2 on t1.id=t2.node_id " +
            "where t1.form_id=#{formId} and t1.type=0 and t2.role_id!=0 and t1.del_flag=0 and t2.del_flag=0 limit 1")
    WfNodeUserEntity queryStartProcessNodeIdByFormId(Long formId);
}
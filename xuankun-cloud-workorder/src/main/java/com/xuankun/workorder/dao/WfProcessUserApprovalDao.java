package com.xuankun.workorder.dao;

import com.xuankun.common.dao.BaseDao;
import com.xuankun.workorder.dto.ProcessUserApprovalListDTO;
import com.xuankun.workorder.entity.WfProcessUserApprovalEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-12
 */
@Mapper
public interface WfProcessUserApprovalDao extends BaseDao<WfProcessUserApprovalEntity> {

    @Select("select * from wf_process_user_approval where order_id = #{orderId} and node_id = #{nodeId} and del_flag = 0 limit 1")
    WfProcessUserApprovalEntity getApproveByOrderIdAndNodeId(@Param("orderId")int orderId,@Param("nodeId") int nodeId);

    @Select("delete from wf_process_user_approval where parent_node_id = #{parentNodeId} and node_id = #{nodeId} and order_id=#{orderId} and is_approval = 0 and del_flag = 0")
    void deleteApproveByParentNodeIdIdAndNodeId(@Param("parentNodeId")int parentNodeId,@Param("nodeId") int nodeId,@Param("orderId") int orderId);

    List<ProcessUserApprovalListDTO> getApproveListByOrderId(@Param("orderId")int orderId);

    @Select("select * from wf_process_user_approval where parent_node_id=#{parentNodeId} and order_id=#{orderId} and form_id=#{formId} and del_flag = 0 " +
            "order by parent_node_id,node_id")
    WfProcessUserApprovalEntity getNodeApprovalInfoByParentNodedId(int parentNodeId,int orderId,long formId);

    /**
     * 计算未会签数量
     * @param nodeId 节点ID
     * @param isApproval 是否审批通过
     * @return 未会签数量
     */
    @Select("select count(*) from wf_process_user_approval where order_id=#{orderId} and is_approval = #{isApproval} and node_id = #{nodeId} and del_flag = 0 ")
    int countProcessNodeByNodeIdAndIsApproval(int orderId,int nodeId,int isApproval);
}
package com.xuankun.workorder.service;

import com.xuankun.common.page.PageData;
import com.xuankun.common.service.CrudService;
import com.xuankun.common.utils.Result;
import com.xuankun.workorder.dto.*;
import com.xuankun.workorder.dto.*;
import com.xuankun.workorder.entity.WorkOrderEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-09-15
 */
public interface WorkOrderService extends CrudService<WorkOrderEntity, WorkOrderDTO> {

    /**
     * 工单审批
     * @param approvedDTO
     * @return
     */
    int approvedWoState(WorkOrderApprovedDTO approvedDTO);

    /**
     * 根据项目ID获取项目信息
     * @param projectId
     * @return
     */
    ProjectInfoDTO getProjectInfo(int projectId);

    /**
     * 根据方案ID获取工单信息
     * @param schemeId
     * @return
     */
    int getWorkOrderInfo(int schemeId);

    /**
     * 我的运维查询接口
     * @param params
     * @return
     */
    PageData<WorkOrderDTO> selectSelfWorkOrder(Map<String, Object> params);

    OperationSchemeDTO findSchemeByWoId(int id);

    List<String> getUserRoleInfo(int userId);

    /**
     * 保存并提交工单
     * @param dto 工单信息
     */
    void saveAndSublitOrder(WorkOrderDTO dto) throws Exception;

    /**
     * 保存工单以及表单信息并提交工单
     * @param dto 工单以及表单信息
     */
    void saveAndSublitOrder(SaveWorkOrderAndFormInfoDTO dto) throws Exception;
    /**
     * 提交工单
     * @param submitOrderDTO 提交工单参数实体类
     * @return
     */
    Result<String> submitOrder(SubmitOrderDTO submitOrderDTO) throws Exception;

    /**
     * 审核工单
     * @param approvalOrderDTO 审核工单参数实体类
     * @return
     */
    Result<String> approvalOrder(ApprovalOrderDTO approvalOrderDTO);

    /**
     * 驳回工单
     * @param approvalOrderDTO 审核工单参数实体类
     * @return
     */
    Result<String> RejectOrder(ApprovalOrderDTO approvalOrderDTO);

    Long updateOrderById(WorkOrderEntity entity);

    /**
     * 处理流程节点，节点审批人设置为：直接上级、多级上级、部门上级、多级部门上级
     * @param parentId
     */
    void handleProcessNodeSetType(int userId,int orderId,int parentId);

    /**
     * 是否存在工单
     * @param formId
     * @return 数量
     */
    int countWorkOrder(Long formId);
}
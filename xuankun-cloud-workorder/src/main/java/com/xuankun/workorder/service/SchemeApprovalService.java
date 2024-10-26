package com.xuankun.workorder.service;

import com.xuankun.common.service.CrudService;
import com.xuankun.workorder.dto.OperationSchemeApprovalDTO;
import com.xuankun.workorder.dto.SchemeApprovalDTO;
import com.xuankun.workorder.entity.SchemeApprovalEntity;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-09-15
 */
public interface SchemeApprovalService extends CrudService<SchemeApprovalEntity, SchemeApprovalDTO> {

    int approvalScheme(OperationSchemeApprovalDTO dto);
}
package com.xuankun.workorder.service;

import com.xuankun.common.page.PageData;
import com.xuankun.common.service.CrudService;
import com.xuankun.workorder.dto.OperationSchemeApprovalDTO;
import com.xuankun.workorder.dto.OperationSchemeDTO;
import com.xuankun.workorder.entity.OperationSchemeEntity;

import java.util.Map;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-09-15
 */
public interface OperationSchemeService extends CrudService<OperationSchemeEntity, OperationSchemeDTO> {

    int approvalScheme(OperationSchemeApprovalDTO dto);

    PageData<OperationSchemeDTO> selectByPage(Map<String, Object> params);


    /**
     * 最新分页查询
     * @param params
     * @return
     */
    PageData<OperationSchemeDTO> findPage(Map<String, Object> params);
}
package com.xuankun.workorder.service;

import com.xuankun.common.service.CrudService;
import com.xuankun.workorder.dto.WfDeployFormDTO;
import com.xuankun.workorder.entity.WfDeployFormEntity;

/**
 * 流程实例关联表单
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-11
 */
public interface WfDeployFormService extends CrudService<WfDeployFormEntity, WfDeployFormDTO> {

    WfDeployFormDTO getDeployFormByOrderId(long orderId);
}
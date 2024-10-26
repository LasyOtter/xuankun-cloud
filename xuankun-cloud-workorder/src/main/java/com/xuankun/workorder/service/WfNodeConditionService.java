package com.xuankun.workorder.service;

import com.xuankun.common.service.CrudService;
import com.xuankun.workorder.dto.WfNodeConditionDTO;
import com.xuankun.workorder.entity.WfNodeConditionEntity;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-11
 */
public interface WfNodeConditionService extends CrudService<WfNodeConditionEntity, WfNodeConditionDTO> {
    void deletNodeConditionByFormId(Long formId);
}
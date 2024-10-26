package com.xuankun.workorder.service;

import com.xuankun.common.service.CrudService;
import com.xuankun.workorder.dto.WfFormFieldDTO;
import com.xuankun.workorder.entity.WfFormFieldEntity;

/**
 * 流程表单字段权限表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-19
 */
public interface WfFormFieldService extends CrudService<WfFormFieldEntity, WfFormFieldDTO> {

    void deleteFormFieldByFormId(Long formId);
}
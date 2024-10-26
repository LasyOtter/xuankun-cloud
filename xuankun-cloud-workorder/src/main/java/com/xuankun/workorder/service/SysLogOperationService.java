package com.xuankun.workorder.service;

import com.xuankun.common.page.PageData;
import com.xuankun.common.service.BaseService;
import com.xuankun.workorder.dto.SysLogOperationDTO;
import com.xuankun.workorder.entity.SysLogOperationEntity;

import java.util.List;
import java.util.Map;

/**
 * 操作日志
 *
 * @since 1.0.0
 */
public interface SysLogOperationService extends BaseService<SysLogOperationEntity> {

    PageData<SysLogOperationDTO> page(Map<String, Object> params);

    List<SysLogOperationDTO> list(Map<String, Object> params);

    void save(SysLogOperationEntity entity);
}
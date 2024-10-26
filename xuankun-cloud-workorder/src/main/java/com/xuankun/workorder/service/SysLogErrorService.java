package com.xuankun.workorder.service;

import com.xuankun.common.page.PageData;
import com.xuankun.common.service.BaseService;
import com.xuankun.workorder.dto.SysLogErrorDTO;
import com.xuankun.workorder.entity.SysLogErrorEntity;

import java.util.List;
import java.util.Map;

/**
 * 异常日志
 *
 * @author Jimy
 * @since 1.0.0
 */
public interface SysLogErrorService extends BaseService<SysLogErrorEntity> {

    PageData<SysLogErrorDTO> page(Map<String, Object> params);

    List<SysLogErrorDTO> list(Map<String, Object> params);

    void save(SysLogErrorEntity entity);

}
package com.xuankun.workorder.service;

import com.xuankun.common.service.CrudService;
import com.xuankun.common.utils.Result;
import com.xuankun.workorder.dto.ProcessFormInfoSaveDTO;
import com.xuankun.workorder.dto.WfProcessDTO;
import com.xuankun.workorder.entity.WfProcessEntity;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-11
 */
public interface WfProcessService extends CrudService<WfProcessEntity, WfProcessDTO> {

    int saveProcessFormInfo(ProcessFormInfoSaveDTO processFormInfoSaveDTO);

    Result<String> updateProcessFormInfo(ProcessFormInfoSaveDTO processFormInfoSaveDTO) throws Exception;
}
package com.xuankun.workorder.service;

import com.xuankun.common.service.CrudService;
import com.xuankun.common.utils.Result;
import com.xuankun.workorder.dto.WfFormDTO;
import com.xuankun.workorder.entity.WfFormEntity;

import java.util.List;

/**
 * 流程表单信息表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-11
 */
public interface WfFormService extends CrudService<WfFormEntity, WfFormDTO> {

    /**
     * 根据用户ID获取用户可以发起的表单
     * @param userIds
     * @return 用户可以发起的表单
     */
    Result<List<WfFormDTO>> getFormListByUserId(List<Integer> userIds);

    List<WfFormDTO> getFormListByUserId(List<Integer> userIds,List<Integer> roleIds);
}
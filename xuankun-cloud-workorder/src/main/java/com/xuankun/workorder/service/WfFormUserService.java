package com.xuankun.workorder.service;

import com.xuankun.common.service.CrudService;
import com.xuankun.workorder.dto.NodeUserDTO;
import com.xuankun.workorder.dto.WfFormUserDTO;
import com.xuankun.workorder.entity.WfFormUserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 表单发起用户表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-20
 */
public interface WfFormUserService extends CrudService<WfFormUserEntity, WfFormUserDTO> {
    /**
     * 根据表单ID删除表单
     * @param formId
     */
    void deleteFormUserByFormId(@Param("formId") long formId);

    List<NodeUserDTO> queryFormUserByFormId(long formId);
}
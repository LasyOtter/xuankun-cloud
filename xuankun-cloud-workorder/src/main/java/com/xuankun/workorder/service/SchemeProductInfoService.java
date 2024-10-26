package com.xuankun.workorder.service;

import com.xuankun.common.service.CrudService;
import com.xuankun.workorder.dto.SchemeProductInfoDTO;
import com.xuankun.workorder.entity.SchemeProductInfoEntity;

import java.util.List;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-09-17
 */
public interface SchemeProductInfoService extends CrudService<SchemeProductInfoEntity, SchemeProductInfoDTO> {
    SchemeProductInfoDTO getSchemeProductInfoBySchemeIdAndProductId(Integer schemeId, Integer productId);

    List<SchemeProductInfoDTO> getSchemeProductInfoBySchemeId(Integer schemeId);
}
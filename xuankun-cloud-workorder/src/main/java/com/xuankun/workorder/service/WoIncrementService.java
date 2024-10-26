package com.xuankun.workorder.service;

import com.xuankun.common.service.CrudService;
import com.xuankun.workorder.dto.WoIncrementDTO;
import com.xuankun.workorder.entity.WoIncrementEntity;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-09-15
 */
public interface WoIncrementService extends CrudService<WoIncrementEntity, WoIncrementDTO> {
    String getIncrementByWoDate();

}
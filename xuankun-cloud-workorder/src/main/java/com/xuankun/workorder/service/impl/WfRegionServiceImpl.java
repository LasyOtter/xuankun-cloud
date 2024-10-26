package com.xuankun.workorder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xuankun.common.service.impl.CrudServiceImpl;
import com.xuankun.workorder.dao.WfRegionDao;
import com.xuankun.workorder.dto.WfRegionDTO;
import com.xuankun.workorder.entity.WfRegionEntity;
import com.xuankun.workorder.service.WfRegionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-30
 */
@Service
public class WfRegionServiceImpl extends CrudServiceImpl<WfRegionDao, WfRegionEntity, WfRegionDTO> implements WfRegionService {

    @Override
    public QueryWrapper<WfRegionEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<WfRegionEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}
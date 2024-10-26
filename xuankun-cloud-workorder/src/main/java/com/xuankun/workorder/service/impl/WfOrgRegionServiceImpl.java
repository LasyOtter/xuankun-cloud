package com.xuankun.workorder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xuankun.common.service.impl.CrudServiceImpl;
import com.xuankun.workorder.dao.WfOrgRegionDao;
import com.xuankun.workorder.dto.WfOrgRegionDTO;
import com.xuankun.workorder.entity.WfOrgRegionEntity;
import com.xuankun.workorder.service.WfOrgRegionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 组织区域对照表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-11-07
 */
@Service
public class WfOrgRegionServiceImpl extends CrudServiceImpl<WfOrgRegionDao, WfOrgRegionEntity, WfOrgRegionDTO> implements WfOrgRegionService {

    @Override
    public QueryWrapper<WfOrgRegionEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");
        String orgId = (String)params.get("orgId");
        String regionId = (String)params.get("regionId");

        QueryWrapper<WfOrgRegionEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);
        wrapper.eq(StringUtils.isNotBlank(orgId), "org_id", orgId);
        wrapper.eq(StringUtils.isNotBlank(regionId), "region_id", regionId);
        return wrapper;
    }


}
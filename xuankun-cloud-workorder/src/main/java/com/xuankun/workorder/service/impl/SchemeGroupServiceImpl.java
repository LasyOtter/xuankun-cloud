package com.xuankun.workorder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xuankun.common.service.impl.CrudServiceImpl;
import com.xuankun.workorder.service.SchemeGroupService;
import com.xuankun.workorder.dao.SchemeGroupDao;
import com.xuankun.workorder.dto.SchemeGroupDTO;
import com.xuankun.workorder.entity.SchemeGroupEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-09-15
 */
@Service
public class SchemeGroupServiceImpl extends CrudServiceImpl<SchemeGroupDao, SchemeGroupEntity, SchemeGroupDTO> implements SchemeGroupService {

    @Override
    public QueryWrapper<SchemeGroupEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");
        String schemeGroup = (String)params.get("schemeGroup");
        QueryWrapper<SchemeGroupEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);
        wrapper.eq(StringUtils.isNotBlank(schemeGroup), "scheme_group", schemeGroup);
        return wrapper;
    }


}
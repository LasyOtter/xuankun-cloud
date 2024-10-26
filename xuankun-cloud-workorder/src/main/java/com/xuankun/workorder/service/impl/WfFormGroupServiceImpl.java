package com.xuankun.workorder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xuankun.common.service.impl.CrudServiceImpl;
import com.xuankun.workorder.service.WfFormGroupService;
import com.xuankun.workorder.dao.WfFormGroupDao;
import com.xuankun.workorder.dto.WfFormGroupDTO;
import com.xuankun.workorder.entity.WfFormGroupEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 表单分组
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-14
 */
@Service
public class WfFormGroupServiceImpl extends CrudServiceImpl<WfFormGroupDao, WfFormGroupEntity, WfFormGroupDTO> implements WfFormGroupService {

    @Override
    public QueryWrapper<WfFormGroupEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<WfFormGroupEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}
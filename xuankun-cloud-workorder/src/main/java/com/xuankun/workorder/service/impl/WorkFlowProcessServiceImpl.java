package com.xuankun.workorder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xuankun.common.service.impl.CrudServiceImpl;
import com.xuankun.workorder.service.WorkFlowProcessService;
import com.xuankun.workorder.dao.WorkFlowProcessDao;
import com.xuankun.workorder.dto.WorkFlowProcessDTO;
import com.xuankun.workorder.entity.WorkFlowProcessEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-09-19
 */
@Service
public class WorkFlowProcessServiceImpl extends CrudServiceImpl<WorkFlowProcessDao, WorkFlowProcessEntity, WorkFlowProcessDTO> implements WorkFlowProcessService {

    @Override
    public QueryWrapper<WorkFlowProcessEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<WorkFlowProcessEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}
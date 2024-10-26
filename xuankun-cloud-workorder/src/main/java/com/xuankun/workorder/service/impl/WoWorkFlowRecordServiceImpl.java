package com.xuankun.workorder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xuankun.common.service.impl.CrudServiceImpl;
import com.xuankun.workorder.service.WoWorkFlowRecordService;
import com.xuankun.workorder.dao.WoWorkFlowRecordDao;
import com.xuankun.workorder.dto.WoWorkFlowRecordDTO;
import com.xuankun.workorder.entity.WoWorkFlowRecordEntity;
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
public class WoWorkFlowRecordServiceImpl extends CrudServiceImpl<WoWorkFlowRecordDao, WoWorkFlowRecordEntity, WoWorkFlowRecordDTO> implements WoWorkFlowRecordService {

    @Override
    public QueryWrapper<WoWorkFlowRecordEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<WoWorkFlowRecordEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}
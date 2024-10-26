package com.xuankun.workorder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xuankun.common.service.impl.CrudServiceImpl;
import com.xuankun.common.utils.ConvertUtils;
import com.xuankun.workorder.service.WoWorkFlowService;
import com.xuankun.workorder.dao.WoWorkFlowDao;
import com.xuankun.workorder.dto.WoWorkFlowDTO;
import com.xuankun.workorder.entity.WoWorkFlowEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-09-19
 */
@Service
public class WoWorkFlowServiceImpl extends CrudServiceImpl<WoWorkFlowDao, WoWorkFlowEntity, WoWorkFlowDTO> implements WoWorkFlowService {

    @Override
    public QueryWrapper<WoWorkFlowEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");
        String workOrderId = (String)params.get("workOrderId");
        String workOrderCode = (String)params.get("workOrderCode");
        String state = (String)params.get("state");
        String stateName = (String)params.get("stateName");

        QueryWrapper<WoWorkFlowEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);
        wrapper.eq(StringUtils.isNotBlank(workOrderId), "work_order_id", workOrderId);
        wrapper.eq(StringUtils.isNotBlank(workOrderCode), "work_order_code", workOrderCode);
        wrapper.eq(StringUtils.isNotBlank(state), "state", state);
        wrapper.eq(StringUtils.isNotBlank(stateName), "state_name", stateName);
        return wrapper;
    }


    @Override
    public WoWorkFlowDTO getWoWorkFlowByWorkOrderId(int workOrderId, int state) {
        WoWorkFlowDTO dto = new WoWorkFlowDTO();
        Map<String, Object> params = new HashMap<>();
        params.put("workOrderId",workOrderId);
        params.put("state",state);
        QueryWrapper<WoWorkFlowEntity> queryWrapper = this.getWrapper(params);
        WoWorkFlowEntity entity = this.baseDao.selectOne(queryWrapper);
        if(entity != null) {
            dto = ConvertUtils.sourceToTarget(entity, WoWorkFlowDTO.class);
        }
        return dto;
    }

    @Override
    public WoWorkFlowDTO getWoWorkFlowByWorkOrderCode(String workOrderCode, int state) {
        WoWorkFlowDTO dto = new WoWorkFlowDTO();
        Map<String, Object> params = new HashMap<>();
        params.put("workOrderCode",workOrderCode);
        params.put("state",state);
        QueryWrapper<WoWorkFlowEntity> queryWrapper = this.getWrapper(params);
        WoWorkFlowEntity entity = this.baseDao.selectOne(queryWrapper);
        if(entity != null) {
            dto = ConvertUtils.sourceToTarget(entity, WoWorkFlowDTO.class);
        }
        return dto;
    }
}
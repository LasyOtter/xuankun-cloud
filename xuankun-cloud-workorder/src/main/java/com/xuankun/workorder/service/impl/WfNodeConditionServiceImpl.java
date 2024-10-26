package com.xuankun.workorder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xuankun.common.service.impl.CrudServiceImpl;
import com.xuankun.workorder.service.WfNodeConditionService;
import com.xuankun.workorder.dao.WfNodeConditionDao;
import com.xuankun.workorder.dto.WfNodeConditionDTO;
import com.xuankun.workorder.entity.WfNodeConditionEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-11
 */
@Service
public class WfNodeConditionServiceImpl extends CrudServiceImpl<WfNodeConditionDao, WfNodeConditionEntity, WfNodeConditionDTO> implements WfNodeConditionService {

    @Override
    public QueryWrapper<WfNodeConditionEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");
        Long formId = (Long)params.get("formId");

        QueryWrapper<WfNodeConditionEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);
        wrapper.eq(formId != null, "form_id", formId);
        return wrapper;
    }


    @Override
    public void deletNodeConditionByFormId(Long formId) {
        Map<String, Object> params = new HashMap<>();
        params.put("formId",formId);
        baseDao.delete(getWrapper(params));
    }
}
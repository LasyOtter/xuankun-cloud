package com.xuankun.workorder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xuankun.common.service.impl.CrudServiceImpl;
import com.xuankun.common.utils.ConvertUtils;
import com.xuankun.workorder.service.WfDeployFormService;
import com.xuankun.workorder.dao.WfDeployFormDao;
import com.xuankun.workorder.dto.WfDeployFormDTO;
import com.xuankun.workorder.entity.WfDeployFormEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 流程实例关联表单
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-11
 */
@Service
public class WfDeployFormServiceImpl extends CrudServiceImpl<WfDeployFormDao, WfDeployFormEntity, WfDeployFormDTO> implements WfDeployFormService {

    @Override
    public QueryWrapper<WfDeployFormEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");
        String formId = (String)params.get("formId");
        String workOrderId = (String)params.get("workOrderId");

        QueryWrapper<WfDeployFormEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);
        wrapper.eq(StringUtils.isNotBlank(formId), "form_id", formId);
        wrapper.eq(StringUtils.isNotBlank(workOrderId), "work_order_id", workOrderId);
        return wrapper;
    }


    @Override
    public WfDeployFormDTO getDeployFormByOrderId(long orderId) {
        QueryWrapper<WfDeployFormEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("work_order_id",orderId);
        WfDeployFormEntity entity = this.baseDao.selectOne(wrapper);
        return ConvertUtils.sourceToTarget(entity, this.currentDtoClass());
    }
}
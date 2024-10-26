package com.xuankun.workorder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xuankun.common.service.impl.CrudServiceImpl;
import com.xuankun.workorder.dao.WfDeptDao;
import com.xuankun.workorder.dto.WfDeptDTO;
import com.xuankun.workorder.entity.WfDeptEntity;
import com.xuankun.workorder.service.WfDeptService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 部门表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-31
 */
@Service
public class WfDeptServiceImpl extends CrudServiceImpl<WfDeptDao, WfDeptEntity, WfDeptDTO> implements WfDeptService {

    @Override
    public QueryWrapper<WfDeptEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");
        String deptId = (String)params.get("deptId");
        String tenantId = (String)params.get("tenantId");
        String leaderUserName = (String)params.get("leaderUserName");
        QueryWrapper<WfDeptEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);
        wrapper.eq(StringUtils.isNotBlank(deptId), "id", deptId);
        wrapper.eq(StringUtils.isNotBlank(tenantId), "tenant_id", tenantId);
        wrapper.like(StringUtils.isNotBlank(leaderUserName), "leader_user_name", leaderUserName);
        return wrapper;
    }


}
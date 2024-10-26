package com.xuankun.workorder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.xuankun.common.service.impl.CrudServiceImpl;
import com.xuankun.workorder.service.WfFormFieldService;
import com.xuankun.workorder.dao.WfFormFieldDao;
import com.xuankun.workorder.dto.WfFormFieldDTO;
import com.xuankun.workorder.entity.WfFormFieldEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 流程表单字段权限表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-19
 */
@Service
public class WfFormFieldServiceImpl extends CrudServiceImpl<WfFormFieldDao, WfFormFieldEntity, WfFormFieldDTO> implements WfFormFieldService {

    @Resource
    private JPAQueryFactory queryFactory;

    @Override
    public QueryWrapper<WfFormFieldEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");
        Long formId = (Long)params.get("formId");

        QueryWrapper<WfFormFieldEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);
        wrapper.eq(formId != null, "form_id", formId);

        return wrapper;
    }


    @Transactional(rollbackFor = {Exception.class}) //注解声明事务捕获到异常回滚
    @Override
    public void deleteFormFieldByFormId(Long formId) {
        Map<String, Object> params = new HashMap<>();
        params.put("formId",formId);
        this.baseDao.delete(getWrapper(params));
    }
}
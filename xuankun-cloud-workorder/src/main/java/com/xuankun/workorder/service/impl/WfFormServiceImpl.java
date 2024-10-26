package com.xuankun.workorder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.xuankun.common.service.impl.CrudServiceImpl;
import com.xuankun.common.utils.Result;
import com.xuankun.workorder.dao.WfFormDao;
import com.xuankun.workorder.dto.WfFormDTO;
import com.xuankun.workorder.entity.QWfFormEntity;
import com.xuankun.workorder.entity.QWfFormUserEntity;
import com.xuankun.workorder.entity.WfFormEntity;
import com.xuankun.workorder.service.WfFormService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 流程表单信息表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-11
 */
@Service
public class WfFormServiceImpl extends CrudServiceImpl<WfFormDao, WfFormEntity, WfFormDTO> implements WfFormService {

    @Resource
    private JPAQueryFactory queryFactory;

    @Override
    public QueryWrapper<WfFormEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");
        String groupId = (String)params.get("groupId");

        QueryWrapper<WfFormEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);
        wrapper.eq(StringUtils.isNotBlank(groupId), "gourp_id", groupId);

        return wrapper;
    }


    @Override
    public Result<List<WfFormDTO>> getFormListByUserId(List<Integer> userIds) {
        if(userIds != null){
            userIds.add(0);
        }
        QWfFormEntity qWfFormEntity = QWfFormEntity.wfFormEntity;
        QWfFormUserEntity qWfFormUserEntity = QWfFormUserEntity.wfFormUserEntity;
        BooleanBuilder queryBuilder = new BooleanBuilder();
        queryBuilder.and(qWfFormUserEntity.userId.in(userIds))
                .and(qWfFormUserEntity.delFlag.eq(0))
                .and(qWfFormEntity.delFlag.eq(0));
        List<WfFormDTO> formList = queryFactory.select(Projections.bean(WfFormDTO.class,qWfFormEntity.formId
                        ,qWfFormEntity.processId,qWfFormEntity.formName,qWfFormEntity.content
                        ,qWfFormEntity.groupId,qWfFormEntity.remark))
                .from(qWfFormEntity)
                .innerJoin(qWfFormUserEntity).on(qWfFormEntity.formId.eq(qWfFormUserEntity.formId).and(qWfFormUserEntity.type.eq(2)))
                .innerJoin(qWfFormUserEntity).on(qWfFormEntity.formId.eq(qWfFormUserEntity.formId).and(qWfFormUserEntity.type.eq(1)))
                .where(queryBuilder).fetch();
        return new Result<List<WfFormDTO>>().ok(formList);
    }

    @Override
    public List<WfFormDTO> getFormListByUserId(List<Integer> userIds,List<Integer> roleIds) {
        if(userIds != null){
            userIds.add(0);
        }
        List<WfFormDTO> formList = this.baseDao.getFormListByUserId(userIds,roleIds);
        return formList;
    }
}
package com.xuankun.workorder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.xuankun.common.service.impl.CrudServiceImpl;
import com.xuankun.workorder.dao.WfFormUserDao;
import com.xuankun.workorder.dto.NodeUserDTO;
import com.xuankun.workorder.dto.WfFormUserDTO;
import com.xuankun.workorder.entity.QWfFormUserEntity;
import com.xuankun.workorder.entity.WfFormUserEntity;
import com.xuankun.workorder.service.WfFormUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 表单发起用户表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-20
 */
@Service
public class WfFormUserServiceImpl extends CrudServiceImpl<WfFormUserDao, WfFormUserEntity, WfFormUserDTO> implements WfFormUserService {

    @Resource
    private JPAQueryFactory queryFactory;

    @Override
    public QueryWrapper<WfFormUserEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<WfFormUserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


    @Override
    public void deleteFormUserByFormId(long formId) {
        this.baseDao.deleteFormUserByFormId(formId);
    }

    @Override
    public List<NodeUserDTO> queryFormUserByFormId(long formId) {
        QWfFormUserEntity formUserEntity = QWfFormUserEntity.wfFormUserEntity;
        return queryFactory.select(Projections.bean(NodeUserDTO.class,formUserEntity.userId.as("id"),formUserEntity.userName.as("name"),formUserEntity.type))
                .from(formUserEntity)
                .where(formUserEntity.formId.eq(formId)).fetch();
    }
}
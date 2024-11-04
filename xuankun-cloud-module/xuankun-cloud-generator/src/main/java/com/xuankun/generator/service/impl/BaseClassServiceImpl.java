package com.xuankun.generator.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xuankun.framework.common.page.PageResult;
import com.xuankun.framework.common.query.DbQuery;
import com.xuankun.framework.common.query.Query;
import com.xuankun.framework.mybatis.service.impl.BaseServiceImpl;
import com.xuankun.generator.dao.BaseClassDao;
import com.xuankun.generator.entity.BaseClassEntity;
import com.xuankun.generator.service.BaseClassService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 基类管理
 *
 * @author jimy
 * 
 */
@Service
public class BaseClassServiceImpl extends BaseServiceImpl<BaseClassDao, BaseClassEntity> implements BaseClassService {

    @Override
    public PageResult<BaseClassEntity> page(DbQuery query) {
        IPage<BaseClassEntity> page = baseMapper.selectPage(
                getPage(query), getWrapper(query)
        );

        return new PageResult<>(page.getRecords(), page.getTotal());
    }

    @Override
    public List<BaseClassEntity> getList() {
        return baseMapper.selectList(null);
    }

    @Override
    public boolean save(BaseClassEntity entity) {
        entity.setCreateTime(new Date());
        return super.save(entity);
    }
}
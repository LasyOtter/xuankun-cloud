package com.xuankun.generator.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xuankun.framework.common.page.PageResult;
import com.xuankun.framework.common.query.DbQuery;
import com.xuankun.framework.mybatis.service.impl.BaseServiceImpl;
import com.xuankun.generator.dao.FieldTypeDao;
import com.xuankun.generator.entity.FieldTypeEntity;
import com.xuankun.generator.service.FieldTypeService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


/**
 * 字段类型管理
 *
 * @author jimy
 * 
 */
@Service
public class FieldTypeServiceImpl extends BaseServiceImpl<FieldTypeDao, FieldTypeEntity> implements FieldTypeService {

    @Override
    public PageResult<FieldTypeEntity> page(DbQuery query) {
        IPage<FieldTypeEntity> page = baseMapper.selectPage(
                getPage(query),
                getWrapper(query)
        );
        return new PageResult<>(page.getRecords(), page.getTotal());
    }

    @Override
    public Map<String, FieldTypeEntity> getMap() {
        List<FieldTypeEntity> list = baseMapper.selectList(null);
        Map<String, FieldTypeEntity> map = new LinkedHashMap<>(list.size());
        for (FieldTypeEntity entity : list) {
            map.put(entity.getColumnType().toLowerCase(), entity);
        }
        return map;
    }

    @Override
    public Set<String> getPackageByTableId(Long tableId) {
        Set<String> importList = baseMapper.getPackageByTableId(tableId);

        return importList.stream().filter(StrUtil::isNotBlank).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getList() {
        return baseMapper.list();
    }

    @Override
    public boolean save(FieldTypeEntity entity) {
        entity.setCreateTime(new Date());
        return super.save(entity);
    }
}
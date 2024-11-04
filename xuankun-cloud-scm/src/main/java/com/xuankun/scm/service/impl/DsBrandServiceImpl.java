package com.xuankun.scm.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xuankun.framework.common.page.PageResult;
import com.xuankun.framework.mybatis.service.impl.BaseServiceImpl;
import com.xuankun.scm.dao.DsBrandDao;
import com.xuankun.scm.entity.DsBrandEntity;
import com.xuankun.scm.convert.DsBrandConvert;
import com.xuankun.scm.query.DsBrandQuery;
import com.xuankun.scm.service.DsBrandService;
import com.xuankun.scm.vo.DsBrandVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DsBrandServiceImpl extends BaseServiceImpl<DsBrandDao, DsBrandEntity> implements DsBrandService {
    @Override
    public PageResult<DsBrandVO> page(DsBrandQuery query) {
        IPage<DsBrandEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(DsBrandConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private Wrapper<DsBrandEntity> getWrapper(DsBrandQuery query){
        LambdaQueryWrapper<DsBrandEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(DsBrandEntity::getId, query.getId());
        wrapper.orderByAsc(DsBrandEntity::getSort);

        return wrapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(DsBrandVO vo) {
        DsBrandEntity entity = DsBrandConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(DsBrandVO vo) {
        DsBrandEntity entity = DsBrandConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }
}

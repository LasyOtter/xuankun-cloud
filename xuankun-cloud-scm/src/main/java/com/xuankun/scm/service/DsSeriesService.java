package com.xuankun.scm.service;

import com.xuankun.framework.common.page.PageResult;
import com.xuankun.framework.mybatis.service.BaseService;
import com.xuankun.scm.entity.DsSeriesEntity;
import com.xuankun.scm.query.DsSeriesQuery;
import com.xuankun.scm.vo.DsSeriesVO;

import java.util.List;

public interface DsSeriesService extends BaseService<DsSeriesEntity> {

    PageResult<DsSeriesVO> page(DsSeriesQuery query);

    void save(DsSeriesVO vo);

    void update(DsSeriesVO vo);

    void delete(List<Long> idList);

}

package com.xuankun.scm.service;

import com.xuankun.framework.common.page.PageResult;
import com.xuankun.framework.mybatis.service.BaseService;
import com.xuankun.scm.entity.DsWaverangeEntity;
import com.xuankun.scm.query.DsWaverangeQuery;
import com.xuankun.scm.vo.DsWaverangeVO;

import java.util.List;

public interface DsWaverangeService extends BaseService<DsWaverangeEntity> {

    PageResult<DsWaverangeVO> page(DsWaverangeQuery query);

    void save(DsWaverangeVO vo);

    void update(DsWaverangeVO vo);

    void delete(List<Long> idList);

}

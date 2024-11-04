package com.xuankun.scm.service;

import com.xuankun.framework.common.page.PageResult;
import com.xuankun.framework.mybatis.service.BaseService;
import com.xuankun.scm.entity.DsSeasonEntity;
import com.xuankun.scm.query.DsSeasonQuery;
import com.xuankun.scm.vo.DsSeasonVO;

import java.util.List;

public interface DsSeasonService extends BaseService<DsSeasonEntity> {

    PageResult<DsSeasonVO> page(DsSeasonQuery query);

    void save(DsSeasonVO vo);

    void update(DsSeasonVO vo);

    void delete(List<Long> idList);

}

package com.xuankun.scm.service;

import com.xuankun.framework.common.page.PageResult;
import com.xuankun.framework.mybatis.service.BaseService;
import com.xuankun.scm.entity.DsYearEntity;
import com.xuankun.scm.query.DsYearQuery;
import com.xuankun.scm.vo.DsYearVO;

import java.util.List;

public interface DsYearService extends BaseService<DsYearEntity> {

    PageResult<DsYearVO> page(DsYearQuery query);

    void save(DsYearVO vo);

    void update(DsYearVO vo);

    void delete(List<Long> idList);

}

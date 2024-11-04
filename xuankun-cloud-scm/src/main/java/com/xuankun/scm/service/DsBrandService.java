package com.xuankun.scm.service;

import com.xuankun.framework.common.page.PageResult;
import com.xuankun.framework.mybatis.service.BaseService;
import com.xuankun.scm.entity.DsBrandEntity;
import com.xuankun.scm.query.DsBrandQuery;
import com.xuankun.scm.vo.DsBrandVO;

import java.util.List;

public interface DsBrandService extends BaseService<DsBrandEntity> {

    PageResult<DsBrandVO> page(DsBrandQuery query);

    void save(DsBrandVO vo);

    void update(DsBrandVO vo);

    void delete(List<Long> idList);

}

package com.xuankun.scm.service;

import com.xuankun.framework.common.page.PageResult;
import com.xuankun.framework.mybatis.service.BaseService;
import com.xuankun.scm.entity.DsCategoryEntity;
import com.xuankun.scm.query.DsCategoryQuery;
import com.xuankun.scm.vo.DsCategoryVO;

import java.util.List;

public interface DsCategoryService extends BaseService<DsCategoryEntity> {

    PageResult<DsCategoryVO> page(DsCategoryQuery query);

    void save(DsCategoryVO vo);

    void update(DsCategoryVO vo);

    void delete(List<Long> idList);

}

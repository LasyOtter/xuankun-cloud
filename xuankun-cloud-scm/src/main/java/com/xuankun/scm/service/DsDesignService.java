package com.xuankun.scm.service;

import com.xuankun.framework.common.page.PageResult;
import com.xuankun.framework.mybatis.service.BaseService;
import com.xuankun.scm.entity.DsDesignEntity;
import com.xuankun.scm.query.DsDesignQuery;
import com.xuankun.scm.vo.DsDesignVO;

import java.util.List;

public interface DsDesignService extends BaseService<DsDesignEntity> {

    PageResult<DsDesignVO> page(DsDesignQuery query);

    void save(DsDesignVO vo);

    void update(DsDesignVO vo);

    void delete(List<Long> idList);

}

package com.xuankun.system.service;

import com.xuankun.framework.common.page.PageResult;
import com.xuankun.framework.mybatis.service.BaseService;
import com.xuankun.system.entity.SysDictDataEntity;
import com.xuankun.system.query.SysDictDataQuery;
import com.xuankun.system.vo.SysDictDataVO;

import java.util.List;

/**
 * 数据字典
 *
 * @author Jimy
 */
public interface SysDictDataService extends BaseService<SysDictDataEntity> {

    PageResult<SysDictDataVO> page(SysDictDataQuery query);

    void save(SysDictDataVO vo);

    void update(SysDictDataVO vo);

    void delete(List<Long> idList);

}
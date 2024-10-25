package com.xuankun.system.service;

import com.xuankun.framework.common.page.PageResult;
import com.xuankun.framework.mybatis.service.BaseService;
import com.xuankun.system.entity.SysDictTypeEntity;
import com.xuankun.system.vo.SysDictVO;
import com.xuankun.system.query.SysDictTypeQuery;
import com.xuankun.system.vo.SysDictTypeVO;

import java.util.List;

/**
 * 数据字典
 *
 * @author Jimy
 */
public interface SysDictTypeService extends BaseService<SysDictTypeEntity> {

    PageResult<SysDictTypeVO> page(SysDictTypeQuery query);

    void save(SysDictTypeVO vo);

    void update(SysDictTypeVO vo);

    void delete(List<Long> idList);

    /**
     * 获取全部字典列表
     */
    List<SysDictVO> getDictList();

}
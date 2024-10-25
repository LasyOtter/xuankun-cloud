package com.xuankun.system.service;

import com.xuankun.framework.common.page.PageResult;
import com.xuankun.framework.mybatis.service.BaseService;
import com.xuankun.system.entity.SysPostEntity;
import com.xuankun.system.query.SysPostQuery;
import com.xuankun.system.vo.SysPostVO;

import java.util.List;

/**
 * 岗位管理
 *
 * @author Jimy
 */
public interface SysPostService extends BaseService<SysPostEntity> {

    PageResult<SysPostVO> page(SysPostQuery query);

    List<SysPostVO> getList();

    void save(SysPostVO vo);

    void update(SysPostVO vo);

    void delete(List<Long> idList);
}
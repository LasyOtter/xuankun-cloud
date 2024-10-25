package com.xuankun.system.service;

import com.xuankun.framework.common.page.PageResult;
import com.xuankun.framework.mybatis.service.BaseService;
import com.xuankun.system.entity.SysRoleEntity;
import com.xuankun.system.query.SysRoleQuery;
import com.xuankun.system.vo.SysRoleDataScopeVO;
import com.xuankun.system.vo.SysRoleVO;

import java.util.List;

/**
 * 角色
 * 
 * @author Jimy
 */
public interface SysRoleService extends BaseService<SysRoleEntity> {

	PageResult<SysRoleVO> page(SysRoleQuery query);

	List<SysRoleVO> getList(SysRoleQuery query);

	void save(SysRoleVO vo);

	void update(SysRoleVO vo);

	void dataScope(SysRoleDataScopeVO vo);

	void delete(List<Long> idList);
}

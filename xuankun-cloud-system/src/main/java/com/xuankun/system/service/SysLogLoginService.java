package com.xuankun.system.service;

import com.xuankun.framework.common.page.PageResult;
import com.xuankun.framework.mybatis.service.BaseService;
import com.xuankun.system.entity.SysLogLoginEntity;
import com.xuankun.system.query.SysLogLoginQuery;
import com.xuankun.system.vo.SysLogLoginVO;

/**
 * 登录日志
 *
 * @author Jimy
 */
public interface SysLogLoginService extends BaseService<SysLogLoginEntity> {

    PageResult<SysLogLoginVO> page(SysLogLoginQuery query);

    /**
     * 保存登录日志
     *
     * @param username  用户名
     * @param status    登录状态
     * @param operation 操作信息
     */
    void save(String username, Integer status, Integer operation);
}
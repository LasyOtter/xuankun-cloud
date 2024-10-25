package com.xuankun.message.service;

import com.xuankun.framework.common.page.PageResult;
import com.xuankun.framework.mybatis.service.BaseService;
import com.xuankun.message.entity.SmsLogEntity;
import com.xuankun.message.query.SmsLogQuery;
import com.xuankun.message.vo.SmsLogVO;

/**
 * 短信日志
 *
 * @author Jimy
 */
public interface SmsLogService extends BaseService<SmsLogEntity> {

    PageResult<SmsLogVO> page(SmsLogQuery query);

}
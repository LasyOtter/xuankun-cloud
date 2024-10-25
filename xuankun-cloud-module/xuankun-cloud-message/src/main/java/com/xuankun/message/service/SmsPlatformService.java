package com.xuankun.message.service;

import com.xuankun.framework.common.page.PageResult;
import com.xuankun.framework.mybatis.service.BaseService;
import com.xuankun.message.entity.SmsPlatformEntity;
import com.xuankun.message.query.SmsPlatformQuery;
import com.xuankun.message.sms.config.SmsConfig;
import com.xuankun.message.vo.SmsPlatformVO;

import java.util.List;

/**
 * 短信平台
 *
 * @author Jimy
 */
public interface SmsPlatformService extends BaseService<SmsPlatformEntity> {

    PageResult<SmsPlatformVO> page(SmsPlatformQuery query);

    /**
     * 启用的短信平台列表
     */
    List<SmsConfig> listByEnable();

    void save(SmsPlatformVO vo);

    void update(SmsPlatformVO vo);

    void delete(List<Long> idList);

}
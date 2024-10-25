package com.xuankun.system.service;

import com.xuankun.framework.common.page.PageResult;
import com.xuankun.framework.mybatis.service.BaseService;
import com.xuankun.system.entity.SysAttachmentEntity;
import com.xuankun.system.query.SysAttachmentQuery;
import com.xuankun.system.vo.SysAttachmentVO;

import java.util.List;

/**
 * 附件管理
 *
 * @author Jimy
 */
public interface SysAttachmentService extends BaseService<SysAttachmentEntity> {

    PageResult<SysAttachmentVO> page(SysAttachmentQuery query);

    void save(SysAttachmentVO vo);

    void update(SysAttachmentVO vo);

    void delete(List<Long> idList);
}
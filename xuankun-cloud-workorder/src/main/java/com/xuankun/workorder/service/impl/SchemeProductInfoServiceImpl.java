package com.xuankun.workorder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xuankun.common.service.impl.CrudServiceImpl;
import com.xuankun.workorder.service.SchemeProductInfoService;
import com.xuankun.workorder.dao.SchemeProductInfoDao;
import com.xuankun.workorder.dto.SchemeProductInfoDTO;
import com.xuankun.workorder.entity.SchemeProductInfoEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-09-17
 */
@Service
public class SchemeProductInfoServiceImpl extends CrudServiceImpl<SchemeProductInfoDao, SchemeProductInfoEntity, SchemeProductInfoDTO> implements SchemeProductInfoService {

    @Override
    public QueryWrapper<SchemeProductInfoEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<SchemeProductInfoEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


    @Override
    public SchemeProductInfoDTO getSchemeProductInfoBySchemeIdAndProductId(Integer schemeId, Integer productId) {
        return this.baseDao.getSchemeProductInfoBySchemeIdAndProductId(schemeId, productId);
    }

    @Override
    public List<SchemeProductInfoDTO> getSchemeProductInfoBySchemeId(Integer schemeId) {
        return this.baseDao.getSchemeProductInfoBySchemeId(schemeId);
    }
}
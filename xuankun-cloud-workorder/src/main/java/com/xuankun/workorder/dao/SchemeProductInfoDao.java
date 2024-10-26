package com.xuankun.workorder.dao;

import com.xuankun.common.dao.BaseDao;
import com.xuankun.workorder.dto.SchemeProductInfoDTO;
import com.xuankun.workorder.entity.SchemeProductInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-09-17
 */
@Mapper
public interface SchemeProductInfoDao extends BaseDao<SchemeProductInfoEntity> {

    @Select("select * from t_scheme_product_info where scheme_id=#{schemeId} and product_model_id=#{productId}")
    SchemeProductInfoDTO getSchemeProductInfoBySchemeIdAndProductId(int schemeId, Integer productId);

    @Select("select * from t_scheme_product_info where scheme_id=#{schemeId}")
    List<SchemeProductInfoDTO> getSchemeProductInfoBySchemeId(int schemeId);
}
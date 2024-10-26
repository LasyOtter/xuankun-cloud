package com.xuankun.workorder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xuankun.common.service.impl.CrudServiceImpl;
import com.xuankun.common.utils.ConvertUtils;
import com.xuankun.workorder.core.constant.XkConstant;
import com.xuankun.workorder.service.SchemeApprovalService;
import com.xuankun.workorder.dao.SchemeApprovalDao;
import com.xuankun.workorder.dto.OperationSchemeApprovalDTO;
import com.xuankun.workorder.dto.SchemeApprovalDTO;
import com.xuankun.workorder.entity.SchemeApprovalEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-09-15
 */
@Service
public class SchemeApprovalServiceImpl extends CrudServiceImpl<SchemeApprovalDao, SchemeApprovalEntity, SchemeApprovalDTO> implements SchemeApprovalService {

    @Override
    public QueryWrapper<SchemeApprovalEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");
        String schemeId = (String)params.get("schemeId");

        QueryWrapper<SchemeApprovalEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);
        wrapper.eq(StringUtils.isNotBlank(schemeId), "scheme_id", schemeId);
        return wrapper;
    }


    @Override
    public int approvalScheme(OperationSchemeApprovalDTO dto) {
        Map<String, Object> params = new HashMap<>();
        params.put("schemeId",dto.getId());
        QueryWrapper<SchemeApprovalEntity> queryWrapper = this.getWrapper(params);
        SchemeApprovalDTO approvalDTO = new SchemeApprovalDTO();
        approvalDTO.setSchemeId(dto.getId());
        approvalDTO.setApprovalState(dto.getApprovalState());
        if(XkConstant.FIRST_REVIEWED.equals(dto.getApprovalLevel())){
            approvalDTO.setFirstReviewedUserId(dto.getReviewedUserId());
            approvalDTO.setFirstReviewedBy(dto.getReviewedBy());
            approvalDTO.setFirstReviewedDate(LocalDateTime.now());
        }
        SchemeApprovalEntity entity = this.baseDao.selectOne(queryWrapper);
        if(entity == null){
            SchemeApprovalEntity newEntity = ConvertUtils.sourceToTarget(approvalDTO, SchemeApprovalEntity.class);
            return this.baseDao.insert(newEntity);
        }
        params.put("id",entity.getId());
        QueryWrapper<SchemeApprovalEntity> wrapper = this.getWrapper(params);
        entity = ConvertUtils.sourceToTarget(approvalDTO, SchemeApprovalEntity.class);
        return this.baseDao.update(entity,wrapper);
    }
}
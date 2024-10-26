package com.xuankun.workorder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xuankun.common.page.PageData;
import com.xuankun.common.service.impl.CrudServiceImpl;
import com.xuankun.workorder.core.constant.XkConstant;
import com.xuankun.workorder.service.OperationSchemeService;
import com.xuankun.workorder.service.SchemeApprovalService;
import com.xuankun.workorder.dao.OperationSchemeDao;
import com.xuankun.workorder.dto.OperationSchemeApprovalDTO;
import com.xuankun.workorder.dto.OperationSchemeDTO;
import com.xuankun.workorder.entity.OperationSchemeEntity;
import com.xuankun.workorder.enums.SchemeApprovalStateEnum;
import com.xuankun.workorder.enums.SchemeApprovalTypeEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-09-15
 */
@Service
public class OperationSchemeServiceImpl extends CrudServiceImpl<OperationSchemeDao, OperationSchemeEntity, OperationSchemeDTO> implements OperationSchemeService {

    @Autowired
    private SchemeApprovalService approvalService;

    @Override
    public QueryWrapper<OperationSchemeEntity> getWrapper(Map<String, Object> params){
        String id = params.get("id") == null?"":params.get("id").toString();
        String schemeName = params.get("schemeName") == null?"":params.get("schemeName").toString();
        String operationType = params.get("operationType")== null?"":params.get("operationType").toString();
        String schemeGroupId = params.get("schemeGroupId")== null?"":params.get("schemeGroupId").toString();
        String approvalState = params.get("approvalState")== null?"":params.get("approvalState").toString();
        QueryWrapper<OperationSchemeEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);
        wrapper.eq(StringUtils.isNotBlank(schemeName), "scheme_name", schemeName);
        wrapper.eq(StringUtils.isNotBlank(operationType), "operation_type", operationType);
        wrapper.eq(StringUtils.isNotBlank(schemeGroupId), "scheme_group_id", schemeGroupId);
        wrapper.eq(StringUtils.isNotBlank(approvalState), "approval_state", approvalState);
        return wrapper;
    }


    @Override
    public int approvalScheme(OperationSchemeApprovalDTO dto) {
        if(XkConstant.FIRST_REVIEWED.equals(dto.getApprovalLevel()) && dto.getApprovalType() == SchemeApprovalTypeEnum.APPROVAL.value()
                && dto.getApprovalState() == SchemeApprovalStateEnum.UNAPPROVED.value()){
            dto.setApprovalState(SchemeApprovalStateEnum.APPROVED.value());
        }
        if(XkConstant.SECOND_REVIEWED.equals(dto.getApprovalLevel()) && dto.getApprovalType() == SchemeApprovalTypeEnum.APPROVAL.value()
                && dto.getApprovalState() == SchemeApprovalStateEnum.FIRST_LEVEL_AUDIT.value()){
            dto.setApprovalState(SchemeApprovalStateEnum.APPROVED.value());
        }
        if(XkConstant.THIRD_REVIEWED.equals(dto.getApprovalLevel()) && dto.getApprovalType() == SchemeApprovalTypeEnum.APPROVAL.value()
                && dto.getApprovalState() == SchemeApprovalStateEnum.SECOND_LEVEL_AUDIT.value()){
            dto.setApprovalState(SchemeApprovalStateEnum.APPROVED.value());
        }
        if(dto.getApprovalType() == SchemeApprovalTypeEnum.REJECT.value()
                && (dto.getApprovalState() > SchemeApprovalStateEnum.UNAPPROVED.value()
                && dto.getApprovalState() < SchemeApprovalStateEnum.APPROVED.value())){
            dto.setApprovalState(dto.getApprovalState() - 1);
        }
        OperationSchemeEntity entity = this.baseDao.selectById(dto.getId());
        entity.setApprovalState(dto.getApprovalState());
        UpdateWrapper<OperationSchemeEntity> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set(dto.getApprovalState() > 0,"approval_state",dto.getApprovalState());
        updateWrapper.eq(StringUtils.isNotBlank(dto.getApprovalLevel()), "approval_level", dto.getApprovalLevel());
        updateWrapper.eq("id",dto.getId());
        this.approvalService.approvalScheme(dto);
        return this.baseDao.update(entity,updateWrapper);
    }

    @Override
    public PageData<OperationSchemeDTO> selectByPage(Map<String, Object> params) {
        QueryWrapper<OperationSchemeEntity> wrapper = this.getWrapper(params);
        IPage<OperationSchemeEntity> page = this.baseDao.selectPage(this.getPage(params, null, false),wrapper);
        return this.getPageData(page, OperationSchemeDTO.class);
    }

    @Override
    public PageData<OperationSchemeDTO> findPage(Map<String, Object> params) {
        IPage<OperationSchemeEntity> page = Page.of(Long.parseLong(params.get("page").toString()) ,Long.parseLong(params.get("limit").toString()));
        QueryWrapper<OperationSchemeEntity> queryWrapper = this.getDtoWrapper(params);
        return this.getPageData(this.baseDao.findPage(page, queryWrapper), OperationSchemeDTO.class);
    }

    public QueryWrapper<OperationSchemeEntity> getDtoWrapper(Map<String, Object> params){
        String id = params.get("id") == null?"":params.get("id").toString();
        String enableCheme = params.get("enableCheme") == null?"":params.get("enableCheme").toString();
        String schemeName = params.get("schemeName") == null?"":params.get("schemeName").toString();
        String operationType = params.get("operationType")== null?"":params.get("operationType").toString();
        String schemeGroupId = params.get("schemeGroupId")== null?"":params.get("schemeGroupId").toString();
        String approvalState = params.get("approvalState")== null?"":params.get("approvalState").toString();
        QueryWrapper<OperationSchemeEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "t1.id", id);
        wrapper.eq(StringUtils.isNotBlank(enableCheme), "t1.enable_cheme", enableCheme);
        wrapper.eq(StringUtils.isNotBlank(schemeName), "t1.scheme_name", schemeName);
        wrapper.eq(StringUtils.isNotBlank(operationType), "t1.operation_type", operationType);
        wrapper.eq(StringUtils.isNotBlank(schemeGroupId), "t1.scheme_group_id", schemeGroupId);
        wrapper.eq(StringUtils.isNotBlank(approvalState), "t1.approval_state", approvalState);
        wrapper.orderByDesc("t1.id");
        return wrapper;
    }
}
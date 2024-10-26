package com.xuankun.workorder.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xuankun.common.dao.BaseDao;
import com.xuankun.workorder.dto.ProjectInfoDTO;
import com.xuankun.workorder.dto.WorkOrderApprovedDTO;
import com.xuankun.workorder.entity.WorkOrderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-09-15
 */
@Mapper
public interface WorkOrderDao extends BaseDao<WorkOrderEntity> {

    /**
     * 工单审批
     * @param approvedDTO
     * @return
     */
    int approvedWoState(WorkOrderApprovedDTO approvedDTO);

    /**
     * 获取项目信息
     * @param projectId
     * @return
     */
    @Select("select id as projectId,name as projectName from t_project where id=#{projectId} ")
    ProjectInfoDTO getProjectInfo(int projectId);

    @Select("select count(1) as total from t_work_order where scheme_id=#{schemeId} ")
    int getWorkOrderInfo(int schemeId);

    @Select("select count(1) as total from t_work_order where form_id=#{formId} and wo_state != 2 and del_flag = 0")
    int countWorkOrder(Long formId);

    IPage<WorkOrderEntity> selectSelfWorkOrder(IPage<WorkOrderEntity> page,@Param("ew") Wrapper<WorkOrderEntity> queryWrapper);


    @Select("select r.`name`  from t_user_role u inner join t_role r on u.roleId=r.id where u.userId=#{userId} ")
    List<String> getUserRoleInfo(int userId);
}
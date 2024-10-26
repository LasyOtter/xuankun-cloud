package com.xuankun.workorder.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xuankun.common.dao.BaseDao;
import com.xuankun.workorder.dto.UserDTO;
import com.xuankun.workorder.dto.WfDeptUserDTO;
import com.xuankun.workorder.entity.WfDeptUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 部门与用户对照表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-11-07
 */
@Mapper
public interface WfDeptUserDao extends BaseDao<WfDeptUserEntity> {

    @Select("select t2.leader_user_id as userId,t2.leader_user_name as userName from wf_dept_user t1 " +
            "INNER JOIN wf_dept t2 on t1.dept_id=t2.id where t1.user_id=#{userId} and t1.del_flag =0 and t2.del_flag =0")
    UserDTO getLeaderByUserId(int userId);

    @Select("SELECT t1.user_id as userId,t2.name AS userName  from wf_user_role t1 " +
            "INNER JOIN t_user t2 on t1.user_id=t2.id where t1.region_id=#{regionId} and t1.del_flag =0  ")
    List<UserDTO> getRegionUserByRegionId(int regionId);

    IPage<WfDeptUserEntity> getDeptUserList(IPage<WfDeptUserEntity> page, @Param("ew") Wrapper<WfDeptUserEntity> queryWrapper);

    List<WfDeptUserEntity> getAllDeptUserList(@Param("ew") Wrapper<WfDeptUserEntity> queryWrapper);

    /**
     * 根据用户ID获取组织ID
     * @param userId
     * @return
     */
    @Select("SELECT t2.tenant_id FROM wf_dept_user t1 INNER JOIN wf_dept t2 ON t1.dept_id = t2.id  " +
            "WHERE t1.del_flag =0 AND t2.del_flag =0 and t1.user_id=#{userId} and t1.del_flag =0 and t2.del_flag =0 ")
    Integer getUserOrgIdByUserId(int userId);
}
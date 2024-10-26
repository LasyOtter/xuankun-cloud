package com.xuankun.workorder.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xuankun.common.dao.BaseDao;
import com.xuankun.workorder.dto.UserDTO;
import com.xuankun.workorder.dto.UserSuperiorDTO;
import com.xuankun.workorder.entity.WfUserSuperiorEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-11-15
 */
@Mapper
public interface WfUserSuperiorDao extends BaseDao<WfUserSuperiorEntity> {

    IPage<UserSuperiorDTO> getAllUserSuperiorInfo(IPage<WfUserSuperiorEntity> page, @Param("ew") Wrapper<WfUserSuperiorEntity> queryWrapper);

    @Select("select t1.parent_user_id as userId,t2.`name` as userName from wf_user_superior t1 " +
            "inner join t_user t2 on t1.parent_user_id=t2.id where t1.del_flag=0 and t1.is_directly=1 and t1.user_id=#{userId} and t1.org_id=#{orgId}")
    UserDTO getSuperiorUserByUserId(int userId,int orgId);

    @Select("select t1.parent_user_id as userId,t2.`name` as userName from wf_user_superior t1 " +
            "inner join t_user t2 on t1.parent_user_id=t2.id where t1.del_flag=0  and t1.user_id=#{userId} and t1.org_id=#{orgId}")
    List<UserDTO> getSuperiorUserListByUserId(int userId,int orgId);

    List<UserSuperiorDTO> getParentUserInfo(List<Integer> userIdList);

    @Select("SELECT t.user_id as userId,t1.`name` as userName FROM wf_user_superior t " +
            "LEFT JOIN t_user t1 on t1.id=t.user_id " +
            "where t.del_flag=0 and parent_user_id=#{parentUserId}")
    UserDTO getChildUserInfo(int parentUserId);

    @Select("SELECT parent_user_id  FROM wf_user_superior WHERE user_id=#{userId} and del_flag=0")
    List<Integer> getParentIdListByUserId(int userId);
}
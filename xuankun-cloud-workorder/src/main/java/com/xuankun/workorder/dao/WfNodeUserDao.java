package com.xuankun.workorder.dao;

import com.xuankun.common.dao.BaseDao;
import com.xuankun.workorder.dto.UserDTO;
import com.xuankun.workorder.entity.WfNodeUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-11
 */
@Mapper
public interface WfNodeUserDao extends BaseDao<WfNodeUserEntity> {
    @Select("select * from wf_node_user where form_id=#{formId} and role_name in (#{roleName}) and del_flag = 0  order by parent_node_id,node_id")
    List<WfNodeUserEntity> getNodeUserInfo(@Param("formId") long formId,@Param("roleName") List<String> roleName);

    @Select("SELECT u.* FROM\twf_node_user u\tINNER JOIN wf_process_node n ON u.form_id = n.form_id \n" +
            "AND u.node_id = n.id WHERE\tu.form_id =#{formId} \tAND u.role_id =#{roleId}\tAND u.type = 2 \t\n" +
            "and u.parent_node_id=0\tand n.type=0\tAND n.is_condition_node = 0\n" +
            "AND u.del_flag = 0 \tAND n.del_flag = 0 UNION ALL\n" +
            "SELECT\tu.* FROM\twf_node_user u INNER JOIN wf_process_node n ON u.form_id = n.form_id \n" +
            "AND u.node_id = n.id WHERE\tu.form_id =#{formId} \tAND u.role_id =#{userId}\tAND u.type = 1 \n" +
            "and n.type=0\tand u.parent_node_id=0\tAND n.is_condition_node = 0\n" +
            "AND u.del_flag = 0 \tAND n.del_flag = 0 UNION ALL\n" +
            "SELECT u.* FROM\twf_node_user u\tINNER JOIN wf_process_node n ON u.form_id = n.form_id \n" +
            "AND u.node_id = n.id WHERE u.form_id =#{formId}\tAND u.type = 3 and n.type=0 AND n.is_condition_node = 0 \n" +
            "AND u.role_id NOT IN ( SELECT role_id FROM wf_node_user WHERE form_id =#{formId} AND is_condition_node = 0 ) \n" +
            "AND u.del_flag = 0 AND n.del_flag = 0 ")
    List<WfNodeUserEntity> getApplyNodeUserInfo(@Param("formId") long formId,@Param("roleId") int roleId,@Param("userId") int userId);

    @Select("SELECT u.* FROM\twf_node_user u INNER JOIN wf_process_node n ON u.form_id = n.form_id \n" +
            "AND u.node_id = n.id WHERE u.form_id =#{formId}\tAND u.role_id =#{userId} AND u.type = 1 \n" +
            "and n.type=0\tAND n.is_condition_node = 1\tAND u.del_flag = 0 \n" +
            "AND n.del_flag = 0 UNION ALL SELECT u.* FROM\twf_node_user u\n" +
            "INNER JOIN wf_process_node n ON u.form_id = n.form_id AND u.node_id = n.id \n" +
            "WHERE u.form_id =#{formId}\tAND u.role_id =#{roleId}\tAND u.type = 2\tAND n.is_condition_node = 1 \n" +
            "AND u.del_flag = 0 AND n.del_flag = 0 UNION ALL\n" +
            "SELECT u.* FROM\twf_node_user u\tINNER JOIN wf_process_node n ON u.form_id = n.form_id \n" +
            "AND u.node_id = n.id WHERE\tu.form_id =#{formId}\tAND u.type = 3\tAND n.is_condition_node = 1 \t\n" +
            "AND u.role_id NOT IN ( SELECT role_id FROM wf_node_user WHERE form_id =#{formId} AND is_condition_node = 1 ) \n" +
            "AND u.del_flag = 0 AND n.del_flag = 0 ")
    List<WfNodeUserEntity> getApplyNodeUserInfoInCondition(@Param("formId") long formId,@Param("roleId") int roleId,@Param("userId") int userId);

    @Select("select * from wf_node_user where form_id=#{formId} and del_flag = 0 order by parent_node_id,node_id")
    List<WfNodeUserEntity> getNodeUserInfoByFormId(long formId);

    @Select("select * from wf_node_user where form_id=#{formId} and type=0 and del_flag = 0")
    List<WfNodeUserEntity> getNodeUserInfoByFormIdAndType(long formId);

    @Select("select * from wf_node_user where parent_node_id=#{parentId} and del_flag = 0  order by parent_node_id,node_id")
    List<WfNodeUserEntity> getNodeUserInfoByParentId(long parentId);

    void deletNodeUserByFormId(Long formId,int roleId);

    void deletNodeUserByOrderId(Long orderId);

    @Select("SELECT n.* from wf_node_user u\n" +
            "INNER JOIN wf_node_user n on u.form_id=n.form_id and u.node_id=n.parent_node_id\n" +
            "inner join wf_process_node node on node.id=n.node_id\n" +
            " where  u.form_id=#{formId} \n" +
            "  and u.role_id=#{userId} and node.is_condition_node=0\n" +
            " and u.type=1 and u.del_flag=0 and n.del_flag=0 \n" +
            " UNION ALL\n" +
            " SELECT n.* from wf_node_user u\n" +
            " INNER JOIN wf_node_user n on u.form_id=n.form_id and u.node_id=n.parent_node_id\n" +
            " inner join wf_process_node node on node.id=n.node_id\n" +
            " where u.role_id=#{roleId} and u.form_id=#{formId}  and node.is_condition_node=0\n" +
            " and u.type=2 and  u.del_flag=0 and n.del_flag=0 \n" +
            " UNION ALL\n" +
            " SELECT n.* from wf_node_user u\n" +
            " INNER JOIN wf_node_user n on u.form_id=n.form_id and u.node_id=n.parent_node_id\n" +
            " inner join wf_process_node node on node.id=n.node_id\n" +
            " where  u.form_id=#{formId} \n" +
            " and u.type=3 and  u.del_flag=0 and n.del_flag=0  and node.is_condition_node=0\n" +
            " and n.role_id not in (select role_id from wf_node_user t1 inner join wf_process_node t2  \n" +
            " on t1.node_id=t2.id and t1.parent_node_id=t2.parent_id and t1.form_id=t2.form_id  \n" +
            " where t1.form_id=#{formId}  and t2.is_condition_node=1 and t1.del_flag=0 and t2.del_flag=0) ")
    List<WfNodeUserEntity> getNodeUserInfoByFormIdAndRoleId(@Param("formId") long formId,@Param("roleId") int roleId,@Param("userId") int userId);

    @Select("select u.* from  wf_node_user u INNER JOIN t_work_order ord on u.form_id=ord.form_id " +
            "where u.del_flag = 0 and ord.id=#{orderId} AND u.form_id = #{formId} AND u.role_id =#{roleId}")
    List<WfNodeUserEntity> getNodeUserInfoByFormIdAndRoleIds(@Param("orderId") int orderId,@Param("formId") long formId,@Param("roleId") int roleId);

    @Select("SELECT t1.userId,t2.`name` as userName FROM t_user_role t1 \n" +
            "INNER JOIN t_user t2 on t1.userId=t2.id\n" +
            "where t1.roleId=#{roleId}")
    List<UserDTO> getUserInfoByRoleId(@Param("roleId") int roleId);


    @Select("select * from wf_node_user t1 where t1.parent_node_id in (select node_id from wf_node_user where form_id=#{formId} and type=0 and del_flag=0)")
    List<WfNodeUserEntity> getApprovalNodeUserInfoByFormId(long formId);

    @Select("select * from wf_node_user t1 where t1.parent_node_id=#{parentNodeId} and t1.del_flag=0 and NOT EXISTS " +
            "(select 1 from wf_process_user_approval t2 where t2.node_user_id=t1.id and t2.del_flag=0) " +
            "and exists (select 1 from wf_process_node t2 where t1.node_id=t2.id and t2.set_type in (4,5,6,7,8) and t2.del_flag=0) " +
            "union ALL " +
            "select * from wf_node_user t1 where t1.parent_node_id=#{parentNodeId} and t1.del_flag=0 and " +
            "not exists (select 1 from wf_process_node t2 where t1.node_id=t2.id and t2.set_type in (4,5,6,7,8) and t2.del_flag=0)")
    List<WfNodeUserEntity> queryApprovalNodeUserByParentNodeId(int parentNodeId);

    @Select("select * FROM wf_node_user where node_id=#{nodeId} and type=#{userType} and role_id=#{roleId} and del_flag=0")
    WfNodeUserEntity queryStartNodeUserByNodeId(int nodeId,int userType,int roleId);

    @Select("select * FROM wf_node_user where parent_node_id=#{nodeId} and type=#{userType} and role_id=#{roleId} and del_flag=0")
    WfNodeUserEntity queryStartNodeUserByParentNodeId(int nodeId,int userType,int roleId);
}
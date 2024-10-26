package com.xuankun.workorder.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 
 * @Description 流程节点用户权限
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-11
 */
@Entity
@Table(name = "wf_node_user")
@Data
@TableName("wf_node_user")
public class WfNodeUserEntity {

    /**
     * 主键
     */
    @Id
    @TableId(type= IdType.AUTO)
	private Integer id;
    /**
     * 表单id
     */
    private Long formId;
    /**
     * 父节点
     */
    private Integer parentNodeId;
    /**
     * 当前节点
     */
	private Integer nodeId;
    /**
     * 角色ID
     */
    private Integer roleId;
    /**
     * 角色
     */
	private String roleName;
    /**
     * 类型:1:用户；2：角色
     */
	private Integer type;
    /**
     * 创建人
     */
	private String creator;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
	private LocalDateTime createDate;
    /**
     * 修改人
     */
	private String updator;
    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateDate;
    /**
     * 流程ID
     */
    private Long processId;
    /**
     * 逻辑删除
     */
    @TableLogic
    private Integer delFlag;

}
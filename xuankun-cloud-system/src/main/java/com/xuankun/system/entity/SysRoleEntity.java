package com.xuankun.system.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.xuankun.framework.mybatis.entity.BaseEntity;
import com.xuankun.system.enums.DataScopeEnum;

/**
 * 角色
 * 
 * @author Jimy
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_role")
public class SysRoleEntity extends BaseEntity {
	/**
	 * 角色名称
	 */
	private String name;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 数据范围  {@link DataScopeEnum}
	 */
	private Integer dataScope;
	/**
	 * 机构ID
	 */
	@TableField(fill = FieldFill.INSERT)
	private Long orgId;
}

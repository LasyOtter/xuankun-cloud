package com.xuankun.framework.mybatis.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import java.io.Serializable;

/**   
* mybatis plus id实体
* @author xxm  
* @date 2021/8/17 
*/
@Getter
@Setter
@FieldNameConstants(innerTypeName = "Id")
public class MpIdEntity implements Serializable {

    private static final long serialVersionUID = 3982181843202226124L;

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
}

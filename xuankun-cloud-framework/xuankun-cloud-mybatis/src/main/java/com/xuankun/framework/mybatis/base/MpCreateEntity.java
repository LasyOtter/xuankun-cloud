package com.xuankun.framework.mybatis.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDateTime;

/**   
 *
 * @author xxm  
 * @date 2022/7/26 
 */
@Getter
@Setter
@FieldNameConstants(innerTypeName="Create")
public class MpCreateEntity extends MpIdEntity{

    /** 创建者ID */
    @TableField(fill = FieldFill.INSERT)
    private Long creator;

    /** 创建时间 */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}

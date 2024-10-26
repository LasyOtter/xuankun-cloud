package com.xuankun.workorder.enums;

/**
 * @author Jimy
 * @Title: NodeSetTypeEnum
 * @Package com.xuankun.workorder.enums
 * @Description: 审批人类型 1指定成员 2发起人自选 3发起人自己 4直属上级 5连续多级上级 6部门上级 7连续多级部门 8表单内区域控件对应审批人
 * @date 2022/11/16:21:14
 */
public enum NodeSetTypeEnum {
    /**
     * 指定成员
     */
    PERSON("指定成员",1),
    /**
     * 发起人自选 selection
     */
    INITIATOR_SELECTION("发起人自选",2),
    /**
     * 发起人自己
     */
    INITIATOR("发起人自己",3),
    /**
     * 直属上级
     */
    DIRECT_SUPERIOR("直属上级",4),
    /**
     * 连续多级上级
     */
    MULTI_SUPERIOR("连续多级上级",5),
    /**
     * 部门上级
     */
    DEPT_SUPERIOR("部门上级",6),
    /**
     * 连续多级部门
     */
    MULTI_DEPT_SUPERIOR("连续多级部门",7),
    /**
     * 表单内区域控件对应审批人
     */
    REGION_SUPERIOR("表单内区域控件对应审批人",8);

    private String enumName;
    private int value;

    NodeSetTypeEnum(String enumName,int value) {
        this.enumName = enumName;
        this.value = value;
    }

    public static int getValue(String enumName) {
        NodeSetTypeEnum[] stateEnums = values();
        for (NodeSetTypeEnum stateEnum : stateEnums) {
            if (stateEnum.enumName().equals(enumName)) {
                return stateEnum.value();
            }
        }
        return 0;
    }

    public static String getEnumName(int value) {
        NodeSetTypeEnum[] stateEnums = values();
        for (NodeSetTypeEnum stateEnum : stateEnums) {
            if (stateEnum.value() == value) {
                return stateEnum.enumName();
            }
        }
        return "";
    }

    public int value(){
        return this.value;
    }
    public String enumName(){
        return this.enumName;
    }
}

package com.xuankun.workorder.enums;

/**
 * @author Jimy
 * @Title: NodeUserTypeEnum
 * @Package com.xuankun.workorder.enums
 * @Description: todo
 * @date 2022/11/17:10:21
 */
public enum NodeUserTypeEnum {
    /**
     * 申请
     */
    USER("用户",1),
    /**
     * 审批
     */
    ROLE("角色",2);

    private String enumName;
    private int value;

    NodeUserTypeEnum(String enumName,int value) {
        this.enumName = enumName;
        this.value = value;
    }

    public static int getValue(String enumName) {
        NodeUserTypeEnum[] stateEnums = values();
        for (NodeUserTypeEnum stateEnum : stateEnums) {
            if (stateEnum.enumName().equals(enumName)) {
                return stateEnum.value();
            }
        }
        return 0;
    }

    public static String getEnumName(int value) {
        NodeUserTypeEnum[] stateEnums = values();
        for (NodeUserTypeEnum stateEnum : stateEnums) {
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

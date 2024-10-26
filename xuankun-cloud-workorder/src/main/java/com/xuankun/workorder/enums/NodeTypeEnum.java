package com.xuankun.workorder.enums;

/**
 * @author Jimy
 * @Title: NodeTypeEnum
 * @Package com.xuankun.workorder.enums
 * @Description: todo
 * @date 2022/11/10:14:41
 */
public enum NodeTypeEnum {
    /**
     * 申请
     */
    ORDER_APPROVED("申请",0),
    /**
     * 审批
     */
    AND_AUDIT("审批",1);

    private String enumName;
    private int value;

    NodeTypeEnum(String enumName,int value) {
        this.enumName = enumName;
        this.value = value;
    }

    public static int getValue(String enumName) {
        NodeTypeEnum[] stateEnums = values();
        for (NodeTypeEnum stateEnum : stateEnums) {
            if (stateEnum.enumName().equals(enumName)) {
                return stateEnum.value();
            }
        }
        return 0;
    }

    public static String getEnumName(int value) {
        NodeTypeEnum[] stateEnums = values();
        for (NodeTypeEnum stateEnum : stateEnums) {
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

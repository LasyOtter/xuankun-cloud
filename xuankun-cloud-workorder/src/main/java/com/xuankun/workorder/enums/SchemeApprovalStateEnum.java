package com.xuankun.workorder.enums;

/**
 * @author Jimy
 * @Title: SchemeApprovalStateEnum
 * @Package com.xuankun.workorder.enums
 * @Description: todo
 * @date 2022/9/16:15:36
 */
public enum SchemeApprovalStateEnum {
    /**
     * 未审核
     */
    UNAPPROVED("未审核",0),
    /**
     * 一级审核 First level audit
     */
    FIRST_LEVEL_AUDIT("待修改",1),
    /**
     * 二级审核
     */
    SECOND_LEVEL_AUDIT("二级审核",2),
    /**
     * 已审核
     */
    APPROVED("已审核",3);

    private String enumName;
    private int value;

    SchemeApprovalStateEnum(String enumName,int value) {
        this.enumName = enumName;
        this.value = value;
    }

    public static int getValue(String enumName) {
        SchemeApprovalStateEnum[] stateEnums = values();
        for (SchemeApprovalStateEnum stateEnum : stateEnums) {
            if (stateEnum.enumName().equals(enumName)) {
                return stateEnum.value();
            }
        }
        return 0;
    }

    public static String getEnumName(int value) {
        SchemeApprovalStateEnum[] stateEnums = values();
        for (SchemeApprovalStateEnum stateEnum : stateEnums) {
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

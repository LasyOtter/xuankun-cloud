package com.xuankun.workorder.enums;

/**
 * @author Jimy
 * @Title: SchemeApprovalTypeEnum
 * @Package com.xuankun.workorder.enums
 * @Description: todo
 * @date 2022/9/16:16:25
 */
public enum SchemeApprovalTypeEnum {
    /**
     * 审核
     */
    APPROVAL("审核",0),
    /**
     * 驳回
     */
    REJECT("驳回",1),
    /**
     * 提交
     */
    SUBMIT("提交",2),
    /**
     * 取消
     */
    CANCEL("取消",3);

    private String enumName;
    private int value;

    SchemeApprovalTypeEnum(String enumName,int value) {
        this.enumName = enumName;
        this.value = value;
    }

    public static int getValue(String enumName) {
        SchemeApprovalTypeEnum[] stateEnums = values();
        for (SchemeApprovalTypeEnum stateEnum : stateEnums) {
            if (stateEnum.enumName().equals(enumName)) {
                return stateEnum.value();
            }
        }
        return 0;
    }

    public static String getEnumName(int value) {
        SchemeApprovalTypeEnum[] stateEnums = values();
        for (SchemeApprovalTypeEnum stateEnum : stateEnums) {
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

package com.xuankun.workorder.enums;

public enum ExamineModeEnum {
    /**
     * 依次审批
     */
    ORDER_APPROVED("依次审批",1),
    /**
     * 会签
     */
    AND_AUDIT("会签",2),
    /**
     * 或签
     */
    OR_AUDIT("或签",3);

    private String enumName;
    private int value;

    ExamineModeEnum(String enumName,int value) {
        this.enumName = enumName;
        this.value = value;
    }

    public static int getValue(String enumName) {
        ExamineModeEnum[] stateEnums = values();
        for (ExamineModeEnum stateEnum : stateEnums) {
            if (stateEnum.enumName().equals(enumName)) {
                return stateEnum.value();
            }
        }
        return 0;
    }

    public static String getEnumName(int value) {
        ExamineModeEnum[] stateEnums = values();
        for (ExamineModeEnum stateEnum : stateEnums) {
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

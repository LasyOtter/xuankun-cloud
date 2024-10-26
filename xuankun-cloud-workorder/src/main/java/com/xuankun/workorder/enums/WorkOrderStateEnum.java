package com.xuankun.workorder.enums;

/**
 * @author Jimy
 * @Title: WorkOrderStateEnum
 * @Package com.xuankun.workorder.enums
 * @Description: 工单状态枚举:
 * 0:已申请
 * 1:处理中
 * 2:已完成
 * 3:已取消
 * 4:已作废
 * @date 2022/9/15:10:35
 */
public enum WorkOrderStateEnum {
    /**
     * 已申请
     */
    REQUESTED("已申请",0),
    /**
     * 处理中
     */
    PROCESSING("处理中",1),
    /**
     * 已完成
     */
    COMPLETED("已完成",2),
    /**
     * 已取消
     */
    CANCELED("已取消",3),
    /**
     * 已作废
     */
    VOIDED("已作废",4);

    private String enumName;
    private int value;

    WorkOrderStateEnum(String enumName,int value) {
        this.enumName = enumName;
        this.value = value;
    }

    public static int getValue(String enumName) {
        WorkOrderStateEnum[] stateEnums = values();
        for (WorkOrderStateEnum stateEnum : stateEnums) {
            if (stateEnum.enumName().equals(enumName)) {
                return stateEnum.value();
            }
        }
        return 0;
    }

    public static String getEnumName(int value) {
        WorkOrderStateEnum[] stateEnums = values();
        for (WorkOrderStateEnum stateEnum : stateEnums) {
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

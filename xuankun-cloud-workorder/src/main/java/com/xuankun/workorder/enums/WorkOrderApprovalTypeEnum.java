package com.xuankun.workorder.enums;

/**
 * @author Jimy
 * @Title: SchemeApprovalTypeEnum
 * @Package com.xuankun.workorder.enums
 * @Description: todo
 * @date 2022/9/16:16:25
 */
public enum WorkOrderApprovalTypeEnum {
    /**
     * 审批
     */
    APPROVAL("审批",0),
    /**
     * 驳回
     */
    REJECT("驳回",1),
    /**
     * 提交
     */
    SUBMIT("提交",2),
    /**
     * 提交
     */
    RELEASE("释放",3),
    /**
     * 提交
     */
    RE_EXECUTE("重新执行",4),
    /**
     * 提交
     */
    ACCEPTANCE_FAILURE("验收失败",5),
    /**
     * 取消
     */
    CANCEL("取消",6);

    private String enumName;
    private int value;

    WorkOrderApprovalTypeEnum(String enumName, int value) {
        this.enumName = enumName;
        this.value = value;
    }

    public static int getValue(String enumName) {
        WorkOrderApprovalTypeEnum[] stateEnums = values();
        for (WorkOrderApprovalTypeEnum stateEnum : stateEnums) {
            if (stateEnum.enumName().equals(enumName)) {
                return stateEnum.value();
            }
        }
        return 0;
    }

    public static String getEnumName(int value) {
        WorkOrderApprovalTypeEnum[] stateEnums = values();
        for (WorkOrderApprovalTypeEnum stateEnum : stateEnums) {
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

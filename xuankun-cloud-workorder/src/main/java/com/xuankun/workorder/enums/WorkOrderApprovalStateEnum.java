package com.xuankun.workorder.enums;

/**
 * @author Jimy
 * @Title: SchemeApprovalStateEnum
 * @Package com.xuankun.workorder.enums
 * @Description: 工单审批状态枚举：
 * 0:已申请   申请节点在申请人提交工单后的状态
 * 1:待审批   审批节点在申请人提交工单后的状态
 * 2:已审批   审批节点审批后的状态
 * 3:已驳回   审批节点驳回后的状态
 * 4:驳回     上一级节点在下一级节点驳回后的状态
 * 5:已作废   特定角色才能做的操作，作废后，所有在该树上的节点全部为已作废
 * 6:已退回   从下面某一级节点退回到该节点所在树某一个节点，沿路节点状态为已退回，退回到某节点的状态叫退回
 * 7:退回     从下面某一级节点退回到该节点所在树某一个节点，沿路节点状态为已退回，退回到某节点的状态叫退回
 * 8:已完成    流程节点全部走完的状态为已完成，待定估计不需要这个状态
 * 9:已取消    待定估计不需要这个状态，跟作废状态冲突
 * @date 2022/10/20:14:36
 */
public enum WorkOrderApprovalStateEnum {
    /**
     * 已申请
     */
    REQUESTED("已申请",0),
    /**
     * 待审批
     */
    TO_BE_APPROVED("待审批",1),
    /**
     * 已审批
     */
    APPROVED("已审批",2),
    /**
     * 已驳回
     */
    REJECTED("已驳回",3),
    /**
     * 驳回
     */
    REJECT("驳回",4),
    /**
     * 已作废
     */
    VOIDED("已作废",5),
    /**
     * 已退回
     */
    RETURNED("已退回",6),
    /**
     * 退回
     */
    RETURN("退回",7),
    /**
     * 已完成
     */
    COMPLETED("已完成",8),
    /**
     * 已取消
     */
    CANCELED("已取消",9);

    private String enumName;
    private int value;

    WorkOrderApprovalStateEnum(String enumName, int value) {
        this.enumName = enumName;
        this.value = value;
    }

    public static int getValue(String enumName) {
        WorkOrderApprovalStateEnum[] stateEnums = values();
        for (WorkOrderApprovalStateEnum stateEnum : stateEnums) {
            if (stateEnum.enumName().equals(enumName)) {
                return stateEnum.value();
            }
        }
        return 0;
    }

    public static String getEnumName(int value) {
        WorkOrderApprovalStateEnum[] stateEnums = values();
        for (WorkOrderApprovalStateEnum stateEnum : stateEnums) {
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

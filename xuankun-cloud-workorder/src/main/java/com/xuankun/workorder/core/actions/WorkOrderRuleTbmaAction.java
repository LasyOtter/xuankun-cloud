package com.xuankun.workorder.core.actions;

import com.xuankun.workorder.dto.WoWorkFlowDTO;
import com.xuankun.workorder.dto.WoWorkFlowRecordDTO;
import lombok.extern.slf4j.Slf4j;
import org.drools.core.definitions.rule.impl.RuleImpl;
import org.springframework.stereotype.Component;

/**
 * @author Jimy
 * @Title: WorkOrderRuleTbmaAction
 * @Package com.xuankun.workorder.actions
 * @Description: todo
 * @date 2022/9/21:16:15
 */
@Slf4j
@Component
public class WorkOrderRuleTbmaAction {

    public static WoWorkFlowDTO doParse(WoWorkFlowDTO dto, WoWorkFlowRecordDTO recordDTO) {
        log.debug("流程:{}已经被处理,{} is Recorded [{}]!",dto.getStateName(), dto, recordDTO);
        return dto;
    }

    public static void logWoWorkFlow(WoWorkFlowDTO obj, RuleImpl rule){
        log.debug("工单号:{}所属流程:{}已经被[{}]处理!",obj.getWorkOrderCode(), obj.getStateName(), rule.getName());
    }

    public static void logWoWorkFlowRecord(WoWorkFlowRecordDTO obj, RuleImpl rule){
        log.debug("工单号:{}所属流程:{}已经被[{}]所记录!",obj.getWorkOrderCode(), obj.getStateName(), rule.getName());
    }
}

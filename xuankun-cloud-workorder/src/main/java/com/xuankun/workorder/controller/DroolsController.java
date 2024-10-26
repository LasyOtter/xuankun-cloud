package com.xuankun.workorder.controller;

import com.xuankun.common.utils.Result;
import com.xuankun.workorder.dto.WorkOrderApprovedDTO;
import com.xuankun.workorder.enums.WorkOrderApprovalTypeEnum;
import com.xuankun.workorder.service.DroolsService;
import com.xuankun.workorder.service.WorkOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.xuankun.workorder.service.WoWorkFlowRecordService;
import com.xuankun.workorder.service.WoWorkFlowService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Jimy
 * @Title: DroolsController
 * @Package com.xuankun.workorder.controller
 * @Description: 规则测试
 * @date 2022/9/21:10:28
 */
@CrossOrigin
@RestController
@RequestMapping("drools/")
@Api(tags="规则测试")
public class DroolsController {

    @Resource
    private DroolsService droolsService;
    @Resource
    private WoWorkFlowService woWorkFlowService;
    @Resource
    private WoWorkFlowRecordService recordService;
    @Resource
    private WorkOrderService workOrderService;

    @GetMapping("testPersonRule")
    @ApiOperation("查看")
    public Result testPersonRule() {
        droolsService.testPersonRule();
        return new Result().ok("规则测试");
    }


    @PostMapping("testWoRule")
    @ApiOperation("测试流程规则文件")
    public Result testWoRule(@RequestBody WorkOrderApprovedDTO approvedDTO) {
        droolsService.testWoRule(approvedDTO,woWorkFlowService,recordService,workOrderService);
        return new Result().ok("测试流程规则文件测试通过");
    }

    @GetMapping("testWoRule1")
    @ApiOperation("测试流程规则文件1")
    public Result testWoRule1() {
        WorkOrderApprovedDTO approvedDTO = new WorkOrderApprovedDTO();
        approvedDTO.setWoId(43);
        approvedDTO.setWoCode("OM20220920000006");
        approvedDTO.setWoState(0);
        approvedDTO.setOrderApprovalTypeEnum(WorkOrderApprovalTypeEnum.APPROVAL.value());
        approvedDTO.setExecutorUserId(31);
        droolsService.testWoRule(approvedDTO,woWorkFlowService,recordService,workOrderService);
        return new Result().ok("测试流程规则文件test.drl测试通过");
    }
}

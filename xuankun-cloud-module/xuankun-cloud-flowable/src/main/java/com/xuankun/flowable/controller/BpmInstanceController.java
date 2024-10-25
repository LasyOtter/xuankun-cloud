package com.xuankun.flowable.controller;

import com.xuankun.flowable.core.instance.service.BpmInstanceOperateService;
import com.xuankun.flowable.core.instance.service.BpmInstanceQueryService;
import com.xuankun.flowable.dto.instance.ActivityInstanceChart;
import com.xuankun.flowable.dto.instance.BpmInstanceDto;
import com.xuankun.flowable.dto.instance.InstanceInfo;
import com.xuankun.flowable.param.instance.InstanceStartParam;
import com.xuankun.framework.common.rest.PageResult;
import com.xuankun.framework.common.rest.Res;
import com.xuankun.framework.common.rest.ResResult;
import com.xuankun.framework.common.rest.param.PageParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**   
 * 流程实例
 * @author xxm  
 * @date 2022/8/24 
 */
@Tag(name = "流程实例")
@RestController
@RequestMapping("/bpm/instance")
@RequiredArgsConstructor
public class BpmInstanceController {
    private final BpmInstanceOperateService operateService;
    private final BpmInstanceQueryService queryService;

    @Operation(summary = "启动任务")
    @PostMapping("/start")
    public ResResult<Void> start(@RequestBody InstanceStartParam instanceParam){
        operateService.start(instanceParam);
        return Res.ok();
    }

    @Operation(summary = "挂起实例")
    @PostMapping("/suspend")
    public ResResult<Void> suspend(String instanceId){
        operateService.suspend(instanceId);
        return Res.ok();
    }

    @Operation(summary = "激活流程")
    @PostMapping("/activate")
    public ResResult<Void> activate(String instanceId){
        operateService.activate(instanceId);
        return Res.ok();
    }

    @Operation(summary = "根据流程Id获取详情")
    @GetMapping("/findByInstanceId")
    public ResResult<BpmInstanceDto> findByInstanceId(String instanceId){
        return Res.ok(queryService.findByInstanceId(instanceId));
    }

    @Operation(summary = "获取当前正在执行的节点")
    @GetMapping("/getCurrentNodes")
    public ResResult<List<String>> getCurrentNodes(String instanceId){
        return Res.ok(queryService.getCurrentNodes(instanceId));
    }

    @Operation(summary = "获取流程执行的节点, 用于绘制流程图")
    @GetMapping("/getFlowNodes")
    public ResResult<List<ActivityInstanceChart>> getFlowNodes(String instanceId){
        return Res.ok(queryService.getFlowNodes(instanceId));
    }

    @Operation(summary = "我发起的流程(分页)")
    @GetMapping("/pageMyApply")
    public ResResult<PageResult<InstanceInfo>> pageMyApply(@ParameterObject PageParam pageParam){
        return Res.ok(queryService.pageMyApply(pageParam));
    }
}

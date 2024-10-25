package com.xuankun.flowable.controller;

import com.xuankun.flowable.core.instance.service.BpmTaskOperateService;
import com.xuankun.flowable.core.instance.service.BpmTaskQueryService;
import com.xuankun.flowable.dto.task.BpmTaskDto;
import com.xuankun.flowable.dto.task.TaskInfo;
import com.xuankun.flowable.param.task.TaskApproveParam;
import com.xuankun.framework.common.rest.PageResult;
import com.xuankun.framework.common.rest.Res;
import com.xuankun.framework.common.rest.ResResult;
import com.xuankun.framework.common.rest.param.PageParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**   
 *
 * @author xxm  
 * @date 2022/8/24 
 */
@Tag(name = "流程任务")
@RestController
@RequestMapping("/bpm/task")
@RequiredArgsConstructor
public class BpmTaskController {
    private final BpmTaskOperateService operateService;
    private final BpmTaskQueryService queryService;

    @Operation(summary = "我的待办")
    @GetMapping("/pageMyTodo")
    public ResResult<PageResult<TaskInfo>> pageMyTodo(PageParam pageParam){
        return Res.ok(queryService.pageMyTodo(pageParam));
    }
    @Operation(summary = "我的已办")
    @GetMapping("/pageMyDone")
    public ResResult<PageResult<TaskInfo>> pageMyDone(PageParam pageParam){
        return Res.ok(queryService.pageMyDone(pageParam));
    }

    @Operation(summary = "通过任务")
    @PostMapping("/pass")
    public ResResult<Void> pass(@RequestBody TaskApproveParam param){
        operateService.pass(param);
        return Res.ok();
    }

    @Operation(summary = "根据任务实例ID查询任务列表")
    @GetMapping("/findAllByInstanceId")
    public ResResult<List<BpmTaskDto>> findAllByInstanceId(String instanceId){
        return Res.ok(queryService.findAllByInstanceId(instanceId));
    }

    @Operation(summary = "获取流程节点的分组任务信息")
    @GetMapping("/getNodeTasks")
    public ResResult<Map<String, List<BpmTaskDto>>> getNodeTasks(String instanceId){
        return Res.ok(queryService.getNodeTasks(instanceId));
    }
    
    @Operation(summary = "驳回")
    @PostMapping("/reject")
    public ResResult<Void> reject(@RequestBody TaskApproveParam param){
        operateService.reject(param);
        return Res.ok();
    }

    @Operation(summary = "任务回退")
    @PostMapping("/flowReturn")
    public ResResult<Void> flowReturn(@RequestBody TaskApproveParam param){
        operateService.reject(param);
        return Res.ok();
    }

    @Operation(summary = "重新分配人员")
    @PostMapping("/assignee")
    public ResResult<Void> assignee(String taskId,Long userId){
        operateService.assignee(taskId,userId);
        return Res.ok();
    }

}

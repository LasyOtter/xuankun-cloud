package com.xuankun.quartz.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import com.xuankun.framework.common.page.PageResult;
import com.xuankun.framework.common.utils.Result;
import com.xuankun.quartz.convert.ScheduleJobConvert;
import com.xuankun.quartz.entity.ScheduleJobEntity;
import com.xuankun.quartz.query.ScheduleJobQuery;
import com.xuankun.quartz.service.ScheduleJobService;
import com.xuankun.quartz.utils.CronUtils;
import com.xuankun.quartz.vo.ScheduleJobVO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
* 定时任务
*
* @author Jimy
*/
@RestController
@Tag(name="定时任务")
@AllArgsConstructor
public class ScheduleJobController {
    private final ScheduleJobService scheduleJobService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('schedule:page')")
    public Result<PageResult<ScheduleJobVO>> page(@Valid ScheduleJobQuery query){
        PageResult<ScheduleJobVO> page = scheduleJobService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('schedule:info')")
    public Result<ScheduleJobVO> get(@PathVariable("id") Long id){
        ScheduleJobEntity entity = scheduleJobService.getById(id);

        return Result.ok(ScheduleJobConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
    @PreAuthorize("hasAuthority('schedule:save')")
    public Result<String> save(@RequestBody ScheduleJobVO vo){
        if (!CronUtils.isValid(vo.getCronExpression())) {
            return Result.error("操作失败，Cron表达式不正确");
        }

        scheduleJobService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @PreAuthorize("hasAuthority('schedule:update')")
    public Result<String> update(@RequestBody @Valid ScheduleJobVO vo) {
        if (!CronUtils.isValid(vo.getCronExpression())) {
            return Result.error("操作失败，Cron表达式不正确");
        }

        scheduleJobService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @PreAuthorize("hasAuthority('schedule:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        scheduleJobService.delete(idList);

        return Result.ok();
    }

    @PutMapping("run")
    @Operation(summary = "立即执行")
    @PreAuthorize("hasAuthority('schedule:run')")
    public Result<String> run(@RequestBody ScheduleJobVO vo){
        scheduleJobService.run(vo);

        return Result.ok();
    }

    @PutMapping("change-status")
    @Operation(summary = "修改状态")
    @PreAuthorize("hasAuthority('schedule:update')")
    public Result<String> changeStatus(@RequestBody ScheduleJobVO vo){
        scheduleJobService.changeStatus(vo);

        return Result.ok();
    }
}
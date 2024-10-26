package com.xuankun.workorder.controller;

import com.xuankun.common.constant.Constant;
import com.xuankun.common.page.PageData;
import com.xuankun.common.utils.Result;
import com.xuankun.common.validator.AssertUtils;
import com.xuankun.common.validator.ValidatorUtils;
import com.xuankun.common.validator.group.AddGroup;
import com.xuankun.common.validator.group.DefaultGroup;
import com.xuankun.common.validator.group.UpdateGroup;
import com.xuankun.workorder.core.annotation.LogOperation;
import com.xuankun.workorder.dto.ProcessFormInfoSaveDTO;
import com.xuankun.workorder.dto.WfProcessDTO;
import com.xuankun.workorder.excel.WfProcessExcel;
import com.xuankun.workorder.service.WfProcessService;
import com.xuankun.workorder.utils.ExcelUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-11
 */
@RestController
@RequestMapping("workorder/wfprocess")
@Api(tags="流程信息")
public class WfProcessController {
    @Autowired
    private WfProcessService wfProcessService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    public Result<PageData<WfProcessDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<WfProcessDTO> page = wfProcessService.page(params);

        return new Result<PageData<WfProcessDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    public Result<WfProcessDTO> get(@PathVariable("id") Long id){
        WfProcessDTO data = wfProcessService.get(id);

        return new Result<WfProcessDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    public Result save(@RequestBody WfProcessDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);
        wfProcessService.save(dto);
        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    public Result update(@RequestBody WfProcessDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        wfProcessService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");
        wfProcessService.delete(ids);
        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<WfProcessDTO> list = wfProcessService.list(params);
        ExcelUtils.exportExcelToTarget(response, null, list, WfProcessExcel.class);
    }

    @PostMapping("saveProcessFormInfo")
    @ApiOperation("保存表单以及流程设计信息")
    @LogOperation("保存表单以及流程设计信息")
    public Result saveProcessFormInfo(@RequestBody ProcessFormInfoSaveDTO processFormInfoSaveDTO){
        //效验数据
        ValidatorUtils.validateEntity(processFormInfoSaveDTO, AddGroup.class, DefaultGroup.class);
        wfProcessService.saveProcessFormInfo(processFormInfoSaveDTO);
        return new Result();
    }

    @PostMapping("updateProcessFormInfo")
    @ApiOperation("修改表单以及流程设计信息")
    @LogOperation("修改表单以及流程设计信息")
    public Result<String> updateProcessFormInfo(@RequestBody ProcessFormInfoSaveDTO processFormInfoSaveDTO) throws Exception {
        //效验数据
        ValidatorUtils.validateEntity(processFormInfoSaveDTO, AddGroup.class, DefaultGroup.class);
        return wfProcessService.updateProcessFormInfo(processFormInfoSaveDTO);
    }
}
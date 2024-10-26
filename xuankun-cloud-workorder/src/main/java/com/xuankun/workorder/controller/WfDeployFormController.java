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
import com.xuankun.workorder.dto.WfDeployFormDTO;
import com.xuankun.workorder.excel.WfDeployFormExcel;
import com.xuankun.workorder.service.WfDeployFormService;
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
 * 流程实例关联表单
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-11
 */
@RestController
@RequestMapping("workorder/wfdeployform")
@Api(tags="流程实例关联表单")
public class WfDeployFormController {
    @Autowired
    private WfDeployFormService wfDeployFormService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    public Result<PageData<WfDeployFormDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<WfDeployFormDTO> page = wfDeployFormService.page(params);

        return new Result<PageData<WfDeployFormDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    public Result<WfDeployFormDTO> get(@PathVariable("id") Long id){
        WfDeployFormDTO data = wfDeployFormService.get(id);

        return new Result<WfDeployFormDTO>().ok(data);
    }

    @GetMapping("getDeployFormByOrderId/{orderId}")
    @ApiOperation("根据工单ID获取表单内容")
    public Result<WfDeployFormDTO> getDeployFormByOrderId(@PathVariable("orderId") int orderId){
        WfDeployFormDTO data = wfDeployFormService.getDeployFormByOrderId(orderId);
        return new Result<WfDeployFormDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    public Result save(@RequestBody WfDeployFormDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        wfDeployFormService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    public Result update(@RequestBody WfDeployFormDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        wfDeployFormService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        wfDeployFormService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<WfDeployFormDTO> list = wfDeployFormService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, list, WfDeployFormExcel.class);
    }

}
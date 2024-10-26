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
import com.xuankun.workorder.dto.WfFormGroupDTO;
import com.xuankun.workorder.excel.WfFormGroupExcel;
import com.xuankun.workorder.service.WfFormGroupService;
import com.xuankun.workorder.utils.ExcelUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 表单分组
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-14
 */
@RestController
@RequestMapping("workorder/wfformgroup")
@Api(tags="表单分组")
public class WfFormGroupController {
    @Autowired
    private WfFormGroupService wfFormGroupService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    public Result<PageData<WfFormGroupDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<WfFormGroupDTO> page = wfFormGroupService.page(params);

        return new Result<PageData<WfFormGroupDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    public Result<WfFormGroupDTO> get(@PathVariable("id") Long id){
        WfFormGroupDTO data = wfFormGroupService.get(id);

        return new Result<WfFormGroupDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    public Result save(@RequestBody WfFormGroupDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        wfFormGroupService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    public Result update(@RequestBody WfFormGroupDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        wfFormGroupService.update(dto);

        return new Result();
    }

    @PostMapping("delete")
    @ApiOperation("删除")
    @LogOperation("删除")
    public Result delete(Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        wfFormGroupService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<WfFormGroupDTO> list = wfFormGroupService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, list, WfFormGroupExcel.class);
    }

    @GetMapping("list")
    @ApiOperation("表单分组列表")
    public Result<List<WfFormGroupDTO>> list() throws Exception {
        Map<String, Object> params = new HashMap<>();
        return new Result<List<WfFormGroupDTO>>().ok(wfFormGroupService.list(params)) ;
    }

}
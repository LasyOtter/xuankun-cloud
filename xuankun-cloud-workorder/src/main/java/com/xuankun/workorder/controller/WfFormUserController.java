package com.xuankun.workorder.controller;

import com.xuankun.common.constant.Constant;
import com.xuankun.common.page.PageData;
import com.xuankun.workorder.core.annotation.LogOperation;
import com.xuankun.workorder.utils.ExcelUtils;
import com.xuankun.common.utils.Result;
import com.xuankun.common.validator.AssertUtils;
import com.xuankun.common.validator.ValidatorUtils;
import com.xuankun.common.validator.group.AddGroup;
import com.xuankun.common.validator.group.DefaultGroup;
import com.xuankun.common.validator.group.UpdateGroup;
import com.xuankun.workorder.dto.WfFormUserDTO;
import com.xuankun.workorder.excel.WfFormUserExcel;
import com.xuankun.workorder.service.WfFormUserService;
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
 * 表单发起用户表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-20
 */
@RestController
@RequestMapping("workorder/wfformuser")
@Api(tags="表单发起用户表")
public class WfFormUserController {
    @Autowired
    private WfFormUserService wfFormUserService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    public Result<PageData<WfFormUserDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<WfFormUserDTO> page = wfFormUserService.page(params);

        return new Result<PageData<WfFormUserDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    public Result<WfFormUserDTO> get(@PathVariable("id") Long id){
        WfFormUserDTO data = wfFormUserService.get(id);

        return new Result<WfFormUserDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    public Result save(@RequestBody WfFormUserDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        wfFormUserService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    public Result update(@RequestBody WfFormUserDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        wfFormUserService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        wfFormUserService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<WfFormUserDTO> list = wfFormUserService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, list, WfFormUserExcel.class);
    }

}
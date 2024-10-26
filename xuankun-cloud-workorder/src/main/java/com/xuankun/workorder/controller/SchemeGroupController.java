package com.xuankun.workorder.controller;

import com.xuankun.common.constant.Constant;
import com.xuankun.common.page.PageData;
import com.xuankun.workorder.utils.ExcelUtils;
import com.xuankun.common.utils.Result;
import com.xuankun.common.validator.AssertUtils;
import com.xuankun.common.validator.ValidatorUtils;
import com.xuankun.common.validator.group.AddGroup;
import com.xuankun.common.validator.group.DefaultGroup;
import com.xuankun.common.validator.group.UpdateGroup;
import com.xuankun.workorder.dto.SchemeGroupDTO;
import com.xuankun.workorder.excel.SchemeGroupExcel;
import com.xuankun.workorder.service.SchemeGroupService;
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
 * @since 1.0.0 2022-09-15
 */
@CrossOrigin
@RestController
@RequestMapping("workorder/schemegroup")
@Api(tags="方案分组")
public class SchemeGroupController {
    @Autowired
    private SchemeGroupService schemeGroupService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    public Result<PageData<SchemeGroupDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<SchemeGroupDTO> page = schemeGroupService.page(params);

        return new Result<PageData<SchemeGroupDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    public Result<SchemeGroupDTO> get(@PathVariable("id") Long id){
        SchemeGroupDTO data = schemeGroupService.get(id);

        return new Result<SchemeGroupDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    public Result save(@RequestBody SchemeGroupDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        schemeGroupService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    public Result update(@RequestBody SchemeGroupDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        schemeGroupService.update(dto);

        return new Result();
    }

    @PostMapping("delete")
    @ApiOperation("删除")
    public Result delete(Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        schemeGroupService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<SchemeGroupDTO> list = schemeGroupService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, list, SchemeGroupExcel.class);
    }

}
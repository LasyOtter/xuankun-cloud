package com.xuankun.workorder.controller;

import com.xuankun.common.constant.Constant;
import com.xuankun.common.page.PageData;
import com.xuankun.workorder.core.annotation.LogOperation;
import com.xuankun.workorder.dto.RoleDTO;
import com.xuankun.workorder.utils.ExcelUtils;
import com.xuankun.common.utils.Result;
import com.xuankun.common.validator.AssertUtils;
import com.xuankun.common.validator.ValidatorUtils;
import com.xuankun.common.validator.group.AddGroup;
import com.xuankun.common.validator.group.DefaultGroup;
import com.xuankun.common.validator.group.UpdateGroup;
import com.xuankun.workorder.dto.WfRoleDTO;
import com.xuankun.workorder.excel.WfRoleExcel;
import com.xuankun.workorder.service.WfRoleService;
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
 * 角色表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-31
 */
@RestController
@RequestMapping("workorder/wfrole")
@Api(tags="角色表")
public class WfRoleController {
    @Autowired
    private WfRoleService wfRoleService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    public Result<PageData<WfRoleDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<WfRoleDTO> page = wfRoleService.page(params);

        return new Result<PageData<WfRoleDTO>>().ok(page);
    }

    @GetMapping("list")
    @ApiOperation("角色列表")
    public Result<List<RoleDTO>> list(){
        List<RoleDTO> page = wfRoleService.getAllRoleName();
        return new Result<List<RoleDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    public Result<WfRoleDTO> get(@PathVariable("id") Long id){
        WfRoleDTO data = wfRoleService.get(id);
        return new Result<WfRoleDTO>().ok(data);
    }

    @GetMapping("getByRoleName")
    @ApiOperation("根据角色名称获取角色id")
    public Result<WfRoleDTO> getByRoleName(String roleName){
        WfRoleDTO data = wfRoleService.getOneByRoleName(roleName);
        return new Result<WfRoleDTO>().ok(data);
    }

    @GetMapping("getNameByRoleId")
    @ApiOperation("根据角色id获取角色名称")
    public Result<String> getNameByRoleId(int roleId){
        String data = wfRoleService.getRoleNameByRoleId(roleId);
        return new Result<String>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    public Result save(@RequestBody WfRoleDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        wfRoleService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    public Result update(@RequestBody WfRoleDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        wfRoleService.update(dto);

        return new Result();
    }

    @PostMapping("delete")
    @ApiOperation("删除")
    @LogOperation("删除")
    public Result delete(Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        wfRoleService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<WfRoleDTO> list = wfRoleService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, list, WfRoleExcel.class);
    }

}
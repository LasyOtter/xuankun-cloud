package com.xuankun.workorder.controller;

import com.xuankun.common.constant.Constant;
import com.xuankun.common.page.PageData;
import com.xuankun.workorder.core.annotation.LogOperation;
import com.xuankun.workorder.dto.*;
import com.xuankun.workorder.utils.ExcelUtils;
import com.xuankun.common.utils.Result;
import com.xuankun.common.validator.AssertUtils;
import com.xuankun.common.validator.ValidatorUtils;
import com.xuankun.common.validator.group.AddGroup;
import com.xuankun.common.validator.group.DefaultGroup;
import com.xuankun.common.validator.group.UpdateGroup;
import com.xuankun.workorder.excel.WfUserRoleExcel;
import com.xuankun.workorder.service.WfUserRoleService;
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
 * 用户权限表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-11-07
 */
@RestController
@RequestMapping("workorder/wfuserrole")
@Api(tags="用户权限表")
public class WfUserRoleController {
    @Autowired
    private WfUserRoleService wfUserRoleService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    public Result<PageData<WfUserRoleDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<WfUserRoleDTO> page = wfUserRoleService.page(params);
        return new Result<PageData<WfUserRoleDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    public Result<WfUserRoleDTO> get(@PathVariable("id") Long id){
        WfUserRoleDTO data = wfUserRoleService.get(id);
        return new Result<WfUserRoleDTO>().ok(data);
    }

    @GetMapping("getRegionUserRoles")
    @ApiOperation("区域角色与用户的对照信息")
    public Result<RegionUserRoleDTO> getRegionUserRoles(int orgId){
        RegionUserRoleDTO data = wfUserRoleService.getRegionUserRoleInfo(orgId);
        return new Result<RegionUserRoleDTO>().ok(data);
    }

    @GetMapping("getUserInfo")
    @ApiOperation("根据区域角色获取用户信息")
    public Result<UserDTO> getUserInfoByRegionIdAndRoleAndUserId(int regionId, int roleId){
        UserDTO data = wfUserRoleService.getUserInfoByRegionIdAndRoleAndUserId(regionId, roleId);
        return new Result<UserDTO>().ok(data);
    }

    @GetMapping("getRoleByUserIdAndOrgId")
    @ApiOperation("根据用户信息取用户角色")
    public Result<List<RoleDTO>> getRoleByUserIdAndOrgId(int userId, int orgId){
        List<RoleDTO> data = wfUserRoleService.getRoleByUserIdAndOrgId(userId, orgId);
        return new Result<List<RoleDTO>>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    public Result save(@RequestBody WfUserRoleDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);
        wfUserRoleService.save(dto);
        return new Result();
    }

    @PostMapping("SaveRegionUserRole")
    @ApiOperation("保存区域角色与用户信息")
    @LogOperation("保存区域角色与用户信息")
    public Result SaveRegionUserRole(@RequestBody SaveRegionUserRoleDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);
        wfUserRoleService.saveRegionUserRole(dto);
        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    public Result update(@RequestBody WfUserRoleDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);
        wfUserRoleService.update(dto);
        return new Result();
    }

    @PostMapping("delete")
    @ApiOperation("删除")
    @LogOperation("删除")
    public Result delete(Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");
        wfUserRoleService.delete(ids);
        return new Result();
    }

    @PostMapping("deleteByRegionIdAndRoleAndUserId")
    @ApiOperation("根据区域以及角色删除")
    @LogOperation("根据区域以及角色删除")
    public Result deleteByRegionIdAndRoleAndUserId(@RequestBody SaveRegionUserRoleDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);
        wfUserRoleService.deleteByRegionIdAndRoleAndUserId(dto);
        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<WfUserRoleDTO> list = wfUserRoleService.list(params);
        ExcelUtils.exportExcelToTarget(response, null, list, WfUserRoleExcel.class);
    }

}
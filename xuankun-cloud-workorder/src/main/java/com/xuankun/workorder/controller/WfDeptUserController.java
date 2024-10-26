package com.xuankun.workorder.controller;

import com.xuankun.common.constant.Constant;
import com.xuankun.common.page.PageData;
import com.xuankun.workorder.core.annotation.LogOperation;
import com.xuankun.workorder.dto.UserDTO;
import com.xuankun.workorder.utils.ExcelUtils;
import com.xuankun.common.utils.Result;
import com.xuankun.common.validator.AssertUtils;
import com.xuankun.common.validator.ValidatorUtils;
import com.xuankun.common.validator.group.AddGroup;
import com.xuankun.common.validator.group.DefaultGroup;
import com.xuankun.common.validator.group.UpdateGroup;
import com.xuankun.workorder.dto.WfDeptUserDTO;
import com.xuankun.workorder.excel.WfDeptUserExcel;
import com.xuankun.workorder.service.WfDeptUserService;
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
 * 部门与用户对照表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-11-07
 */
@RestController
@RequestMapping("workorder/wfdeptuser")
@Api(tags="部门与用户对照表")
public class WfDeptUserController {
    @Autowired
    private WfDeptUserService wfDeptUserService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String"),
            @ApiImplicitParam(name = "orgId", value = "组织ID", paramType = "query" , dataType="int") ,
            @ApiImplicitParam(name = "deptId", value = "部门ID", paramType = "query", dataType="int") ,
            @ApiImplicitParam(name = "userId", value = "用户ID", paramType = "query", dataType="int")
    })
    public Result<PageData<WfDeptUserDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<WfDeptUserDTO> page = wfDeptUserService.getDeptUserList(params);
        return new Result<PageData<WfDeptUserDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    public Result<WfDeptUserDTO> get(@PathVariable("id") Long id){
        WfDeptUserDTO data = wfDeptUserService.get(id);
        return new Result<WfDeptUserDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    public Result save(@RequestBody WfDeptUserDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);
        wfDeptUserService.save(dto);
        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    public Result update(@RequestBody WfDeptUserDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);
        wfDeptUserService.update(dto);
        return new Result();
    }

    @PostMapping("delete")
    @ApiOperation("删除")
    @LogOperation("删除")
    public Result delete(Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");
        wfDeptUserService.delete(ids);
        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<WfDeptUserDTO> list = wfDeptUserService.list(params);
        ExcelUtils.exportExcelToTarget(response, null, list, WfDeptUserExcel.class);
    }

    @GetMapping("getLeaderByUserId")
    @ApiOperation("根据用户ID获取部门上级")
    public Result<UserDTO> getLeaderByUserId(int userId) {
        UserDTO dto = wfDeptUserService.getLeaderByUserId(userId);
        return new Result<UserDTO>().ok(dto);
    }

    @GetMapping("getMultiUserByUserId")
    @ApiOperation("根据用户ID获取多级部门上级")
    public Result<List<UserDTO>> getMultiUserByUserId(int userId,int step) {
        List<UserDTO> dtos = wfDeptUserService.getMultiUserByUserId(userId,step);
        return new Result<List<UserDTO>>().ok(dtos);
    }

    @GetMapping("getRegionUserByRegionId")
    @ApiOperation("根据用户ID获取表单内区域控件对应审批人")
    public Result<List<UserDTO>> getRegionUserByRegionId(int regionId) {
        List<UserDTO> dtos = wfDeptUserService.getRegionUserByRegionId(regionId);
        return new Result<List<UserDTO>>().ok(dtos);
    }

    @GetMapping("getAllDeptUserList")
    @ApiOperation("部门用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orgId", value = "组织ID", paramType = "query" , dataType="int") ,
            @ApiImplicitParam(name = "deptId", value = "部门ID", paramType = "query", dataType="int") ,
            @ApiImplicitParam(name = "userId", value = "用户ID", paramType = "query", dataType="int")
    })
    public Result<List<WfDeptUserDTO>> getAllDeptUserList(@ApiIgnore @RequestParam Map<String, Object> params) {
        List<WfDeptUserDTO> dtos = wfDeptUserService.getAllDeptUserList(params);
        return new Result<List<WfDeptUserDTO>>().ok(dtos);
    }
}
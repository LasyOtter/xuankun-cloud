package com.xuankun.workorder.controller;

import com.xuankun.common.constant.Constant;
import com.xuankun.common.page.PageData;
import com.xuankun.workorder.core.annotation.LogOperation;
import com.xuankun.workorder.dto.UserDTO;
import com.xuankun.workorder.dto.UserSuperiorDTO;
import com.xuankun.workorder.utils.ExcelUtils;
import com.xuankun.common.utils.Result;
import com.xuankun.common.validator.AssertUtils;
import com.xuankun.common.validator.ValidatorUtils;
import com.xuankun.common.validator.group.AddGroup;
import com.xuankun.common.validator.group.DefaultGroup;
import com.xuankun.common.validator.group.UpdateGroup;
import com.xuankun.workorder.dto.WfUserSuperiorDTO;
import com.xuankun.workorder.excel.WfUserSuperiorExcel;
import com.xuankun.workorder.service.WfUserSuperiorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @describe 上级管理
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-11-15
 */
@RestController
@RequestMapping("workorder/wfusersuperior")
@Api(tags="上级管理")
public class WfUserSuperiorController {
    @Autowired
    private WfUserSuperiorService wfUserSuperiorService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    public Result<PageData<UserSuperiorDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<UserSuperiorDTO> page = wfUserSuperiorService.getAllUserSuperiorInfo(params);
        return new Result<PageData<UserSuperiorDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    public Result<WfUserSuperiorDTO> get(@PathVariable("id") Long id){
        WfUserSuperiorDTO data = wfUserSuperiorService.get(id);
        return new Result<WfUserSuperiorDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    public Result save(@RequestBody WfUserSuperiorDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);
        List<UserDTO> userList = this.wfUserSuperiorService.getChildUserInfo(dto.getParentUserId());
        if(userList != null && !userList.isEmpty()){
            List<Integer> userIdList = new ArrayList<>();
            for (UserDTO userDTO:userList) {
                userIdList.add(userDTO.getUserId());
            }
            if (!userIdList.isEmpty()) {
                if(userIdList.contains(dto.getUserId())){
                    return new Result().error("该用户已存在上级中");
                }
            }
        }
        wfUserSuperiorService.save(dto);
        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    public Result update(@RequestBody WfUserSuperiorDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);
        wfUserSuperiorService.update(dto);
        return new Result();
    }

    @PostMapping("delete")
    @ApiOperation("删除")
    @LogOperation("删除")
    public Result delete(Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");
        wfUserSuperiorService.delete(ids);
        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<WfUserSuperiorDTO> list = wfUserSuperiorService.list(params);
        ExcelUtils.exportExcelToTarget(response, null, list, WfUserSuperiorExcel.class);
    }

    @GetMapping("getSuperiorUserByUserId")
    @ApiOperation("获取直属上级")
    public Result<UserDTO> getSuperiorUserByUserId(int userId, int orgId){
        UserDTO data = wfUserSuperiorService.getSuperiorUserByUserId(userId,orgId);
        return new Result<UserDTO>().ok(data);
    }

    @GetMapping("getSuperiorUsersByUserId")
    @ApiOperation("获取连续多级上级")
    public Result<List<UserDTO>> getSuperiorUsersByUserId(int userId, int orgId,int step){
        List<UserDTO> data = wfUserSuperiorService.getSuperiorUserByUserId(userId,orgId,step);
        return new Result<List<UserDTO>>().ok(data);
    }

    @GetMapping("getParentUserInfo")
    @ApiOperation("获取用户上级")
    public Result<List<UserSuperiorDTO>> getParentUserInfo(int userId){
        List<UserSuperiorDTO> data = wfUserSuperiorService.getParentUserInfo(userId);
        return new Result<List<UserSuperiorDTO>>().ok(data);
    }

    @GetMapping("getChildUserInfo")
    @ApiOperation("获取用户下级")
    public Result<List<UserDTO>> getChildUserInfo(int parentUserId){
        List<UserDTO> data = wfUserSuperiorService.getChildUserInfo(parentUserId);
        return new Result<List<UserDTO>>().ok(data);
    }
}
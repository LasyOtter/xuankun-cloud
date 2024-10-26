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
import com.xuankun.workorder.dto.QueryNodeUserInfoDTO;
import com.xuankun.workorder.dto.WfProcessNodeDTO;
import com.xuankun.workorder.excel.WfProcessNodeExcel;
import com.xuankun.workorder.service.WfNodeUserService;
import com.xuankun.workorder.service.WfProcessNodeService;
import com.xuankun.workorder.utils.ExcelUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
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
@RequestMapping("workorder/wfprocessnode")
@Api(tags="")
public class WfProcessNodeController {
    @Autowired
    private WfProcessNodeService wfProcessNodeService;
    @Resource
    private WfNodeUserService nodeUserService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    public Result<PageData<WfProcessNodeDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<WfProcessNodeDTO> page = wfProcessNodeService.page(params);

        return new Result<PageData<WfProcessNodeDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    public Result<WfProcessNodeDTO> get(@PathVariable("id") Long id){
        WfProcessNodeDTO data = wfProcessNodeService.get(id);
        return new Result<WfProcessNodeDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    public Result save(@RequestBody WfProcessNodeDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);
        wfProcessNodeService.save(dto);
        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    public Result update(@RequestBody WfProcessNodeDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);
        wfProcessNodeService.update(dto);
        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");
        wfProcessNodeService.delete(ids);
        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<WfProcessNodeDTO> list = wfProcessNodeService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, list, WfProcessNodeExcel.class);
    }

    @PostMapping("getNodeUserInfo")
    @ApiOperation("测试多角色")
    public Result<Object> getNodeUserInfo(@RequestBody QueryNodeUserInfoDTO dto) {
        return new Result<Object>().ok(nodeUserService.getNodeUserInfo(dto.getOrderId(),dto.getFormId(), dto.getRoleName()));
    }
}
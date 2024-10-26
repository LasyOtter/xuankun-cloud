package com.xuankun.workorder.controller;

import com.alibaba.fastjson2.JSONObject;
import com.xuankun.common.constant.Constant;
import com.xuankun.common.page.PageData;
import com.xuankun.common.utils.Result;
import com.xuankun.common.validator.AssertUtils;
import com.xuankun.common.validator.ValidatorUtils;
import com.xuankun.common.validator.group.AddGroup;
import com.xuankun.common.validator.group.DefaultGroup;
import com.xuankun.common.validator.group.UpdateGroup;
import com.xuankun.workorder.core.annotation.LogOperation;
import com.xuankun.workorder.dto.*;
import com.xuankun.workorder.excel.WfFormExcel;
import com.xuankun.workorder.service.WfDeployFormService;
import com.xuankun.workorder.service.WfFormService;
import com.xuankun.workorder.service.WfFormUserService;
import com.xuankun.workorder.service.WfProcessService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 流程表单信息表
 *
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-10-11
 */
@RestController
@RequestMapping("workorder/wfform")
@Api(tags="流程表单信息表")
public class WfFormController {
    @Resource
    private WfFormService wfFormService;
    @Resource
    private WfProcessService wfProcessService;

    @Resource
    private WfFormUserService formUserService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    public Result<PageData<WfFormDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<WfFormDTO> page = wfFormService.page(params);
        return new Result<PageData<WfFormDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    public Result<WfFormDTO> get(@PathVariable("id") Long id){
        WfFormDTO data = wfFormService.get(id);
        return new Result<WfFormDTO>().ok(data);
    }

    @GetMapping("getProcessInfo/{id}")
    @ApiOperation("获取流程信息")
    public Result<ProcessFormInfoSaveDTO> getProcessInfo(@PathVariable("id") Long id){
        WfFormDTO data = wfFormService.get(id);
        if(data == null){
            return new Result<ProcessFormInfoSaveDTO>().ok(null);
        }
        List<NodeUserDTO> nodeUserList = formUserService.queryFormUserByFormId(id);
        WfProcessDTO processDTO = wfProcessService.get(data.getProcessId());
        ProcessFormInfoSaveDTO processFormInfoSaveDTO = new ProcessFormInfoSaveDTO();
        ProcessFormSetting formSetting = new ProcessFormSetting();
        formSetting.setId(data.getFormId());
        formSetting.setGroupId(data.getGroupId());
        formSetting.setName(data.getFormName());
        formSetting.setRemark(data.getRemark());
        formSetting.setNodeUserList(nodeUserList);
        processFormInfoSaveDTO.setFormContent(data.getContent());
        processFormInfoSaveDTO.setFormSetting(formSetting);
        ProcessInfoDTO processInfoDTO = new ProcessInfoDTO();
        processInfoDTO.setId(processDTO.getId());
        processInfoDTO.setDirectorMaxLevel(processDTO.getDirectorMaxLevel());
        processInfoDTO.setFormId(processDTO.getFormId());
        processInfoDTO.setNodeConfig(JSONObject.parseObject(processDTO.getProcessNode(),ProcessSettingInfoDTO.class));
        processFormInfoSaveDTO.setProcessDTO(processInfoDTO);
        return new Result<ProcessFormInfoSaveDTO>().ok(processFormInfoSaveDTO);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    public Result save(@RequestBody WfFormDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);
        wfFormService.save(dto);
        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    public Result update(@RequestBody WfFormDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);
        wfFormService.update(dto);
        return new Result();
    }

    @PostMapping("delete")
    @ApiOperation("删除")
    @LogOperation("删除")
    public Result delete(Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");
        wfFormService.delete(ids);
        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<WfFormDTO> list = wfFormService.list(params);
        ExcelUtils.exportExcelToTarget(response, null, list, WfFormExcel.class);
    }

    @GetMapping("list")
    @ApiOperation("表单列表-old")
    public Result<List<WfFormDTO>> list() {
        Map<String, Object> params = new HashMap<>();
        List<WfFormDTO> list = wfFormService.list(params);
        return new Result<List<WfFormDTO>>().ok(list);
    }

    @PostMapping("listNew")
    @ApiOperation("表单列表")
    public Result<List<WfFormDTO>> listNew(@RequestBody QueryFormDTO dto) {
        List<WfFormDTO> list = wfFormService.getFormListByUserId(dto.getUserIds(),dto.getRoleIds());
        return new Result<List<WfFormDTO>>().ok(list);
    }
}
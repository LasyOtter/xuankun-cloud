package com.xuankun.workorder.controller;

import com.xuankun.common.constant.Constant;
import com.xuankun.common.page.PageData;
import com.xuankun.common.utils.ConvertUtils;
import com.xuankun.workorder.dto.OperationSchemeApprovalDTO;
import com.xuankun.workorder.dto.SchemeProductInfoDTO;
import com.xuankun.workorder.entity.SchemeProductInfoEntity;
import com.xuankun.workorder.service.SchemeProductInfoService;
import com.xuankun.workorder.service.WorkOrderService;
import com.xuankun.workorder.utils.ExcelUtils;
import com.xuankun.common.utils.Result;
import com.xuankun.common.validator.AssertUtils;
import com.xuankun.common.validator.ValidatorUtils;
import com.xuankun.common.validator.group.AddGroup;
import com.xuankun.common.validator.group.DefaultGroup;
import com.xuankun.common.validator.group.UpdateGroup;
import com.xuankun.workorder.dto.OperationSchemeDTO;
import com.xuankun.workorder.excel.OperationSchemeExcel;
import com.xuankun.workorder.service.OperationSchemeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
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
@RequestMapping("workorder/operationscheme")
@Api(tags="运维方案")
public class OperationSchemeController {
    @Autowired
    private OperationSchemeService operationSchemeService;
    @Autowired
    private SchemeProductInfoService productInfoService;
    @Autowired
    private WorkOrderService workOrderService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    public Result<PageData<OperationSchemeDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<OperationSchemeDTO> page = operationSchemeService.findPage(params);
        return new Result<PageData<OperationSchemeDTO>>().ok(page);
    }

    @GetMapping("list")
    @ApiOperation("列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "schemeName", value = "方案名称", paramType = "query",  dataType="String") ,
            @ApiImplicitParam(name = "operationType", value = "运维类型", paramType = "query", dataType="String")
    })
    public Result<List<OperationSchemeDTO>> list(@ApiIgnore @RequestParam Map<String, Object> params){
        List<OperationSchemeDTO> list = operationSchemeService.list(params);
        return new Result<List<OperationSchemeDTO>>().ok(list);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    public Result<OperationSchemeDTO> get(@PathVariable("id") int id){
        Map<String, Object> params = new HashMap<>();
        params.put("id",id);
        params.put("page",1);
        params.put("limit",10);
        PageData<OperationSchemeDTO> page = operationSchemeService.findPage(params);
        OperationSchemeDTO data = new OperationSchemeDTO();
        if(page.getTotal() > 0){
            data = page.getList().get(0);
        }
        if(data.getId() != null && productInfoService.getSchemeProductInfoBySchemeId(data.getId()) != null) {
            data.setProductInfos(productInfoService.getSchemeProductInfoBySchemeId(data.getId()));
        }
        return new Result<OperationSchemeDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    public Result save(@RequestBody OperationSchemeDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);
        operationSchemeService.save(dto);
        List<SchemeProductInfoDTO> productInfoDTOS = dto.getProductInfos();
        if(productInfoDTOS != null || productInfoDTOS.size() > 0) {
            for (SchemeProductInfoDTO productInfoDTO : productInfoDTOS){
                productInfoDTO.setSchemeId(dto.getId());
            }
            List<SchemeProductInfoEntity> productInfoList = ConvertUtils.sourceToTarget(productInfoDTOS, SchemeProductInfoEntity.class);
            productInfoService.insertBatch(productInfoList);
        }
        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    public Result update(@RequestBody OperationSchemeDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);
        operationSchemeService.update(dto);
        List<SchemeProductInfoDTO> productInfoDTOS = dto.getProductInfos();
        if(productInfoDTOS != null || productInfoDTOS.size() > 0) {
            List<SchemeProductInfoDTO> insertProductInfoDTOS = new ArrayList<>();
            List<SchemeProductInfoDTO> updateProductInfoDTOS = new ArrayList<>();
            for (SchemeProductInfoDTO productInfoDTO : productInfoDTOS){
                productInfoDTO.setSchemeId(dto.getId());
                SchemeProductInfoDTO infoDTO = productInfoService.getSchemeProductInfoBySchemeIdAndProductId(productInfoDTO.getSchemeId(),productInfoDTO.getProductModelId());
                if(infoDTO == null){
                    insertProductInfoDTOS.add(productInfoDTO);
                }else{
                    productInfoDTO.setId(infoDTO.getId());
                    updateProductInfoDTOS.add(productInfoDTO);
                }
            }
            if(insertProductInfoDTOS != null || insertProductInfoDTOS.size() > 0) {
                List<SchemeProductInfoEntity> insertProductInfoList = ConvertUtils.sourceToTarget(insertProductInfoDTOS, SchemeProductInfoEntity.class);
                productInfoService.insertBatch(insertProductInfoList);
            }
            if(updateProductInfoDTOS != null || updateProductInfoDTOS.size() > 0) {
                List<SchemeProductInfoEntity> updateProductInfoList = ConvertUtils.sourceToTarget(updateProductInfoDTOS, SchemeProductInfoEntity.class);
                productInfoService.updateBatchById(updateProductInfoList);
            }
        }
        return new Result();
    }

    @PostMapping("delete")
    @ApiOperation("删除")
    public Result delete(Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");
        if(workOrderService.getWorkOrderInfo(Math.toIntExact(ids[0])) > 0){
            return new Result().error("该方案已有工单引用,不能删除");
        }
        operationSchemeService.delete(ids);
        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<OperationSchemeDTO> list = operationSchemeService.list(params);
        ExcelUtils.exportExcelToTarget(response, null, list, OperationSchemeExcel.class);
    }

    @PutMapping("approvalScheme")
    @ApiOperation("审批")
    public Result update(@RequestBody OperationSchemeApprovalDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);
        operationSchemeService.approvalScheme(dto);
        return new Result();
    }

    @GetMapping("pagetest")
    @ApiOperation("分页测试")
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
            @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
            @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
            @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    public Result<PageData<OperationSchemeDTO>> pageTest(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<OperationSchemeDTO> page = operationSchemeService.findPage(params);
        return new Result<PageData<OperationSchemeDTO>>().ok(page);
    }
}
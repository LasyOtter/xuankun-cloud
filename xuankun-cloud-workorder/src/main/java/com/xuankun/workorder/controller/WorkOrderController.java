package com.xuankun.workorder.controller;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.xuankun.common.constant.Constant;
import com.xuankun.common.page.PageData;
import com.xuankun.workorder.core.annotation.LogOperation;
import com.xuankun.workorder.service.*;
import com.xuankun.workorder.dto.*;
import com.xuankun.workorder.entity.*;
import com.xuankun.workorder.utils.ExcelUtils;
import com.xuankun.common.utils.Result;
import com.xuankun.common.validator.AssertUtils;
import com.xuankun.common.validator.ValidatorUtils;
import com.xuankun.common.validator.group.AddGroup;
import com.xuankun.common.validator.group.DefaultGroup;
import com.xuankun.common.validator.group.UpdateGroup;
import com.xuankun.workorder.excel.WorkOrderExcel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Jimy 545631327@qq.com
 * @since 1.0.0 2022-09-15
 */
@CrossOrigin
@RestController
@RequestMapping("workorder/")
@Api(tags = "工单")
public class WorkOrderController {
    @Resource
    private WorkOrderService workOrderService;
    @Resource
    private OperationSchemeService schemeService;
    @Resource
    private WoIncrementService woIncrementService;
    @Resource
    private SchemeProductInfoService productInfoService;

    @Resource
    private WfNodeUserService nodeUserService;

    @Resource
    private WfDeployFormService deployFormService;

    @Resource
    private WfProcessNodeService nodeService;

    @Resource
    private WfProcessUserApprovalService approvalService;

    @Resource
    private JPAQueryFactory queryFactory;


    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String")
    })
    public Result<PageData<WorkOrderDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params) {
        PageData<WorkOrderDTO> page = workOrderService.page(params);
        return new Result<PageData<WorkOrderDTO>>().ok(page);
    }

    @GetMapping("list")
    @ApiOperation("工单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "woState", value = "工单状态", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "schemeName", value = "方案名称", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "executorRole", value = "执行角色", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "operationType", value = "运维类型", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "beginDate", value = "计划执行时间-开始", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "endDate", value = "计划执行时间-结束", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "woCode", value = "工单号", paramType = "query", dataType = "String")
    })
    public Result<List<WorkOrderDTO>> list(@ApiIgnore @RequestParam Map<String, Object> params) {
        List<WorkOrderDTO> page = workOrderService.list(params);
        return new Result<List<WorkOrderDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("查看")
    public Result<SchemeOrderDTO> get(@PathVariable("id") Long id) {
        SchemeOrderDTO data = new SchemeOrderDTO();
        WorkOrderDTO orderDTO = workOrderService.get(id);
        Map<String, Object> params = new HashMap<>();
        params.put("id", orderDTO.getSchemeId());
        params.put("page", 1);
        params.put("limit", 10);
        PageData<OperationSchemeDTO> page = schemeService.findPage(params);
        OperationSchemeDTO schemeDTO = new OperationSchemeDTO();
        if (page.getTotal() > 0) {
            schemeDTO = page.getList().get(0);
        }
        if (schemeDTO.getId() != null && productInfoService.getSchemeProductInfoBySchemeId(schemeDTO.getId()) != null) {
            schemeDTO.setProductInfos(productInfoService.getSchemeProductInfoBySchemeId(schemeDTO.getId()));
        }
        if (orderDTO.getProjectId() != null) {
            ProjectInfoDTO projectInfoDTO = workOrderService.getProjectInfo(orderDTO.getProjectId());
            if (projectInfoDTO != null && !StringUtils.isEmpty(projectInfoDTO.getProjectName())) {
                orderDTO.setProjectName(projectInfoDTO.getProjectName());
            }
        }
        WfDeployFormDTO deployFormDTO = new WfDeployFormDTO();
        deployFormDTO = deployFormService.getDeployFormByOrderId(id);
        data.setWorkOrderDTO(orderDTO);
        data.setOperSchemeDTO(schemeDTO);
        data.setDeployFormDTO(deployFormDTO);
        return new Result<SchemeOrderDTO>().ok(data);
    }

    @GetMapping("getApproveListByOrderId")
    @ApiOperation("查看流程审批信息列表")
    Result<List<ProcessUserApprovalListDTO>> getApproveListByOrderId(int orderId) {
        List<ProcessUserApprovalListDTO> data = approvalService.getApproveListByOrderId(orderId);
        return new Result<List<ProcessUserApprovalListDTO>>().ok(data);
    }

    @GetMapping("getNodeFlowInfo")
    @ApiOperation("查看流程图审批信息列表")
    Result<List<PorcessNodeFlowInfoDTO>> getNodeFlowInfo(int orderId) {
        List<PorcessNodeFlowInfoDTO> data = nodeService.getNodeFlowInfo(orderId);
        return new Result<List<PorcessNodeFlowInfoDTO>>().ok(data);
    }

    @PostMapping("save")
    @ApiOperation("保存")
    @LogOperation("保存")
    public Result save(@RequestBody WorkOrderDTO dto) {
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);
        try {
            workOrderService.saveAndSublitOrder(dto);
        } catch (Exception e) {
            return new Result().error(e.getMessage());
        }
        return new Result();
    }

    @PostMapping("saveNew")
    @ApiOperation("保存工单以及表单信息并提交工单")
    @LogOperation("保存工单以及表单信息并提交工单")
    public Result saveNew(@RequestBody SaveWorkOrderAndFormInfoDTO dto) {
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);
        //效验工单数据
        ValidatorUtils.validateEntity(dto.getWorkOrderDTO(), AddGroup.class, DefaultGroup.class);
        try {
            workOrderService.saveAndSublitOrder(dto);
        } catch (Exception e) {
            return new Result().error(e.getMessage());
        }
        return new Result();
    }

    @PutMapping("update")
    @ApiOperation("修改")
    @LogOperation("修改")
    public Result update(@RequestBody WorkOrderDTO dto) {
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);
        workOrderService.update(dto);
        return new Result();
    }

    @PostMapping("delete")
    @ApiOperation("删除")
    @LogOperation("删除")
    public Result delete(Long[] ids) {
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");
        workOrderService.delete(ids);
        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<WorkOrderDTO> list = workOrderService.list(params);
        ExcelUtils.exportExcelToTarget(response, null, list, WorkOrderExcel.class);
    }

    @PutMapping("approvedWoState")
    @ApiOperation("审批-old")
    public Result approvedWoState(@RequestBody WorkOrderApprovedDTO dto) {
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);
        workOrderService.approvedWoState(dto);
        return new Result();
    }

    @GetMapping("myOmPage")
    @ApiOperation("我的运维分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = "userId", value = "用户ID", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String")
    })
    public Result<PageData<WorkOrderDTO>> myOmPage(@ApiIgnore @RequestParam Map<String, Object> params) {
        PageData<WorkOrderDTO> page = workOrderService.selectSelfWorkOrder(params);
        return new Result<PageData<WorkOrderDTO>>().ok(page);
    }

    @GetMapping("findSchemeByWoId/{id}")
    @ApiOperation("根据工号ID查询方案信息")
    public Result<OperationSchemeEntity> findSchemeByWoId(@PathVariable("id") int id) {
        QOperationSchemeEntity schemeEntity = QOperationSchemeEntity.operationSchemeEntity;
        QWorkOrderEntity workOrderEntity = QWorkOrderEntity.workOrderEntity;
        BooleanBuilder queryBuilder = new BooleanBuilder();
        queryBuilder.and(workOrderEntity.id.eq(id));
        OperationSchemeEntity schemeDTO = queryFactory.select(Projections.bean(OperationSchemeEntity.class, schemeEntity))
                .from(schemeEntity)
                .innerJoin(workOrderEntity)
                .on(schemeEntity.id.eq(workOrderEntity.schemeId))
                .where(queryBuilder).fetchOne();
        return new Result<OperationSchemeEntity>().ok(schemeDTO);
    }

    @PutMapping("submitOrder")
    @ApiOperation("提交工单")
    @LogOperation("提交工单")
    public Result<String> submitOrder(@RequestBody SubmitOrderDTO submitOrderDTO) throws Exception {
        return workOrderService.submitOrder(submitOrderDTO);
    }

    @PutMapping("approvalOrder")
    @ApiOperation("审批工单")
    @LogOperation("审批工单")
    public Result<String> approvalOrder(@RequestBody ApprovalOrderDTO approvalOrderDTO){
        return workOrderService.approvalOrder(approvalOrderDTO);
    }
}
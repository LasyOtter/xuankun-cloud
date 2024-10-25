package com.xuankun.flowable.core.instance.service;

import cn.hutool.core.util.StrUtil;
import com.xuankun.flowable.core.model.dao.BpmModelManager;
import com.xuankun.flowable.core.model.entity.BpmModel;
import com.xuankun.flowable.exception.ModelNotExistException;
import com.xuankun.flowable.exception.ModelNotPublishException;
import com.xuankun.flowable.local.BpmContext;
import com.xuankun.flowable.local.BpmContextLocal;
import com.xuankun.flowable.param.instance.InstanceStartParam;
import com.xuankun.framework.security.user.UserDetail;
import com.xuankun.framework.security.utils.SecurityUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.RuntimeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

import static com.xuankun.flowable.code.ModelCode.PUBLISHED;

/**
 * 流程实例
 * @author xxm
 * @date 2022/8/23 
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BpmInstanceOperateService {
    private final BpmModelManager bpmModelManager;

    private final RuntimeService runtimeService;

    /**
     * 启动一个流程
     */
    @Transactional(rollbackFor = Exception.class)
    public void start(InstanceStartParam instanceParam){
        BpmModel bpmModel = bpmModelManager.findById(instanceParam.getModelId()).orElseThrow(ModelNotExistException::new);
        // 未发布
        if (!Objects.equals(bpmModel.getPublish(), PUBLISHED)){
            throw new ModelNotPublishException();
        }
        Optional<UserDetail> currentUser = SecurityUtil.getCurrentUser();
        String userName = currentUser.map(UserDetail::getUsername).orElse("未知");

        String title = instanceParam.getName();
        if (StrUtil.isBlank(title)){
            title = bpmModel.getName() + "[" + userName +"]";
        }
        BpmContext bpmContext = BpmContextLocal.get();
        bpmContext.setFormVariables(instanceParam.getFormVariables())
                .setStartUser(currentUser);
        BpmContextLocal.put(bpmContext);

        runtimeService.createProcessInstanceBuilder()
                .processDefinitionId(bpmModel.getDefId())
                .name(title)
                .start();
    }


    /**
     * 挂起实例
     */
    public void suspend(String instanceId){
        // 激活状态
        runtimeService.suspendProcessInstanceById(instanceId);
    }

    /**
     * 激活流程
     */
    public void activate(String instanceId){
        // 非激活状态
        runtimeService.activateProcessInstanceById(instanceId);
    }

}

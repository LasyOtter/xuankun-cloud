package com.xuankun.workorder.service.impl;

import com.drools.core.KieTemplate;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.xuankun.workorder.service.WoWorkFlowRecordService;
import com.xuankun.workorder.service.WoWorkFlowService;
import com.xuankun.workorder.service.WorkOrderService;
import com.xuankun.workorder.service.DroolsService;
import com.xuankun.workorder.dto.PersonDTO;
import com.xuankun.workorder.dto.WorkOrderApprovedDTO;
import com.xuankun.workorder.dto.WorkOrderDTO;
import com.xuankun.workorder.entity.QWoWorkFlowEntity;
import com.xuankun.workorder.entity.QWorkOrderEntity;
import org.apache.commons.lang3.StringUtils;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Jimy
 * @Title: DroolsServiceImpl
 * @Package com.xuankun.workorder.service.impl
 * @Description: todo
 * @date 2022/9/21:10:20
 */
@Service
public class DroolsServiceImpl implements DroolsService {
    @Autowired
    private KieTemplate kieTemplate;

    private KieSession kSession;

    @Resource
    private JPAQueryFactory queryFactory;

    @Override
    public void testPersonRule() {
        kSession = kieTemplate.getKieSession("ai-rules.drl");
        PersonDTO bob = new PersonDTO();
        bob.setName("bob");
        kSession.insert(bob);

        PersonDTO other = new PersonDTO();
        other.setName("other1");
        other.setAge(26);
        kSession.insert(other);

        PersonDTO jimy = new PersonDTO();
        jimy.setName("jimy");
        jimy.setAge(30);
        kSession.insert(jimy);

        PersonDTO jib = new PersonDTO();
        jib.setName("jib");
        jib.setAge(46);
        kSession.insert(jib);

        PersonDTO heJib = new PersonDTO();
        heJib.setName("heJib");
        heJib.setAge(56);
        kSession.insert(heJib);

        int rules = kSession.fireAllRules();
        kSession.destroy();
        kSession.dispose();
    }

    @Override
    public void testWoRule(WorkOrderApprovedDTO approvedDTO, WoWorkFlowService woWorkFlowService, WoWorkFlowRecordService recordService, WorkOrderService workOrderService) {
        kSession = kieTemplate.getKieSession("work-order-work-flow-test.drl");
        kSession.setGlobal("woWorkFlowService",woWorkFlowService);
        kSession.setGlobal("recordService",recordService);
        kSession.setGlobal("workOrderService",workOrderService);
        kSession.insert(approvedDTO);
        int rules = kSession.fireAllRules();
        kSession.destroy();
        kSession.dispose();
    }

    public void testJpa(String workOrderCode){
        BooleanBuilder queryBuilder = new BooleanBuilder();
        QWoWorkFlowEntity workFlowEntity = QWoWorkFlowEntity.woWorkFlowEntity;
        QWorkOrderEntity workOrderEntity = QWorkOrderEntity.workOrderEntity;
        if(StringUtils.isNoneEmpty(workOrderCode)){
            queryBuilder.and(workOrderEntity.woCode.eq(workOrderCode));
        }
        List<WorkOrderDTO> workOrderDTOS = queryFactory.select(Projections.bean(WorkOrderDTO.class,workOrderEntity))
                .from(workOrderEntity)
                .leftJoin(workFlowEntity)
                .on(QWoWorkFlowEntity.woWorkFlowEntity.workOrderId.eq(QWorkOrderEntity.workOrderEntity.id))
                .where(queryBuilder)
                .fetch();
    }
}

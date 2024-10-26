package com.xuankun.workorder.core.actions;

import com.xuankun.workorder.dto.PersonDTO;
import lombok.extern.slf4j.Slf4j;
import org.drools.core.definitions.rule.impl.RuleImpl;

/**
 * @author Jimy
 * @Title: PersonRuleAction
 * @Package com.xuankun.workorder.action
 * @Description: todo
 * @date 2022/9/21:10:14
 */
@Slf4j
public class PersonRuleAction {

    // 目前只实现记录日志功能
    public static void doParse(PersonDTO person, RuleImpl rule) {
        log.debug("{} is matched Rule[{}]!", person, rule.getName());
    }
}

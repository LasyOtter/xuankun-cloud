package com.xuankun.flowable.exception;

import com.xuankun.framework.common.exception.BizException;

/**
* 流程实例不存在
* @author xxm  
* @date 2020/3/1 15:28 
*/
public class InstanceNotExistException extends BizException {
    public InstanceNotExistException(String message) {
        super(message);
    }

    public InstanceNotExistException() {
        super("流程实例不存在");
    }
}

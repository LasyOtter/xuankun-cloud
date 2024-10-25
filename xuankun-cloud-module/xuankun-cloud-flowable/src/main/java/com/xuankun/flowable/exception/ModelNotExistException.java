package com.xuankun.flowable.exception;

import com.xuankun.framework.common.exception.BizException;

/**
* 流程模型定义不存在
* @author xxm  
* @date 2020/3/1 13:33 
*/
public class ModelNotExistException extends BizException {
    public ModelNotExistException(String message) {
        super(message);
    }

    public ModelNotExistException() {
        super("流程模型定义不存在");
    }
}

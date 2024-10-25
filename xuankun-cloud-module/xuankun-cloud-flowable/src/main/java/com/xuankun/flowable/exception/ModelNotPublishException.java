package com.xuankun.flowable.exception;

import com.xuankun.framework.common.exception.BizException;

/**
 * 流程模型未发布
 * @author xxm
 * @date 2020/3/1 19:25
 */
public class ModelNotPublishException extends BizException {
    public ModelNotPublishException(String message) {
        super(message);
    }

    public ModelNotPublishException() {
        super("流程模型未发布");
    }
}

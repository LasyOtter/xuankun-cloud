package com.xuankun.framework.security.exception;

import com.xuankun.framework.common.exception.BizException;

/**
* 未登录异常
* @author xxm
* @date 2021/12/22
*/
public class NotLoginException extends BizException {

    public NotLoginException(String msg){
        super(msg);
    }

    public NotLoginException() {
        super("未登录");
    }
}

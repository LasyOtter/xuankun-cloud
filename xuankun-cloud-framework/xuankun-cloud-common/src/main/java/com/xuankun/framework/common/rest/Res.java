package com.xuankun.framework.common.rest;

import static com.xuankun.framework.common.code.CommonCode.FAIL_CODE;
import static com.xuankun.framework.common.code.CommonCode.SUCCESS_CODE;

/**
* 返回工具类
* @author xxm  
* @date 2020/1/22 15:29 
*/
public class Res{

    private final static String SUCCESS = "success";

    private final static String FAILED = "failed";

    public static <T> ResResult<T> ok() {
        return new ResResult<T>(SUCCESS_CODE, SUCCESS);
    }

    public static <T> ResResult<T> okAndMsg(String message) {
        return new ResResult<T>(SUCCESS_CODE, message);
    }

    public static <T> ResResult<T> ok(T data) {
        return new ResResult<T>(SUCCESS_CODE, data, SUCCESS);
    }

    public static <T> ResResult<T> error() {
        return new ResResult<T>(FAIL_CODE, FAILED);
    }

    public static <T> ResResult<T> error(String message) {
        return new ResResult<T>(FAIL_CODE, message);
    }

    public static <T> ResResult<T> response(int code, String msg) {
        return new ResResult<T>(code, msg);
    }

    public static <T> ResResult<T> response(int code, String msg,String traceId) {
        return new ErrorResult<T>(code, msg,traceId);
    }

    public static <T> ResResult<T> response(int code, String msg, T data) {
        return new ResResult<T>(code, data, msg);
    }


}

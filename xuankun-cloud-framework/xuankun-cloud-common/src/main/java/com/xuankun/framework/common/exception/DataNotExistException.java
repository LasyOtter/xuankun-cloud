package com.xuankun.framework.common.exception;

import static com.xuankun.framework.common.code.CommonErrorCode.DATA_NOT_EXIST;

/**
* 数据不存在异常
* @author xxm  
* @date 2022/1/10 
*/
public class DataNotExistException extends BizException{

    public DataNotExistException(String msg) {
        super(DATA_NOT_EXIST, msg);
    }
    public DataNotExistException() {
        super(DATA_NOT_EXIST, "数据不存在");
    }

}

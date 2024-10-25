package com.xuankun.framework.common.exception;

import java.io.Serializable;

import static com.xuankun.framework.common.code.CommonErrorCode.DATA_OUT_OF_DATE;

/**
 * 乐观锁异常
 * @author xxm
 * @date 2020/4/15 14:11
 */
public class OptimisticLockException extends SystemException implements Serializable {
    private static final long serialVersionUID = -1605410024618499135L;

    public OptimisticLockException(){
        super(DATA_OUT_OF_DATE,"数据不存在或者已过期");
    }
}

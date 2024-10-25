package com.xuankun.framework.common.code;

/**
 * 公共常量
 * @author xxm
 * @date 2020/4/8 10:58
 */
public interface CommonCode {

    /** 服务器地址 */
    String SERVER_URL = "ServerUrl";

    /** 开发环境 */
    String ENV_DEV = "dev";
    /** 测试环境 */
    String ENV_TEST = "test";
    /** 生产环境 */
    String ENV_PROD = "prod";
    
    /**
     * 实体类删除标记
     */
    String DELETE_FLAG = "1";

    /**
     * 实体类正常标记
     */
    String NORMAL_FLAG = "0";

    /**
     * 系统默认用户的 userId，便于定时任务和异步任务时使用
     */
    Long SYSTEM_DEFAULT_USERID = 1L;

    /**
     * 事件路由Key
     */
    String EVENT_ROUTER_KEY = "event_router_key";

    /**
     * 响应成功码
     */
    int SUCCESS_CODE = 0;

    /**
     * 响应失败码
     */
    int FAIL_CODE = 1;

    /** 追踪Id */
    String TRACE_ID = "traceId";

    String USER = "user";

    String USER_ID = "userId";

    String DEPT_ID = "dept_id";

    String ID = "id";

    String CREATOR = "creator";

    String CREATE_TIME = "createTime";

    String LAST_MODIFIER = "lastModifier";

    String LAST_MODIFIED_TIME = "lastModifiedTime";

    String VERSION = "version";

    String DELETED = "deleted";
}

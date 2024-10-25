package com.xuankun.message.sms;

import java.util.Map;

/**
 * 短信
 *
 * @author Jimy
 */
public interface SmsStrategy {

    /**
     * 发送短信
     * @param mobile  手机号
     * @param params  参数
     */
    void send(String mobile, Map<String, String> params);
}

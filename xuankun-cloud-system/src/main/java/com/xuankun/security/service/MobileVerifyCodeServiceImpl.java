package com.xuankun.security.service;

import lombok.AllArgsConstructor;
import com.xuankun.api.module.message.SmsApi;
import com.xuankun.framework.common.utils.Result;
import com.xuankun.framework.security.mobile.MobileVerifyCodeService;
import org.springframework.stereotype.Service;

/**
 * 短信验证码效验
 *
 * @author Jimy
 */
@Service
@AllArgsConstructor
public class MobileVerifyCodeServiceImpl implements MobileVerifyCodeService {
    private final SmsApi smsApi;

    @Override
    public boolean verifyCode(String mobile, String code) {
        Result<Boolean> result = smsApi.verifyCode(mobile, code);

        return result.getData();
    }
}

package com.xuankun.system.service;

import com.xuankun.system.vo.SysAccountLoginVO;
import com.xuankun.system.vo.SysMobileLoginVO;
import com.xuankun.system.vo.SysTokenVO;

/**
 * 权限认证服务
 *
 * @author Jimy
 */
public interface SysAuthService {

    /**
     * 账号密码登录
     *
     * @param login 登录信息
     */
    SysTokenVO loginByAccount(SysAccountLoginVO login);

    /**
     * 手机短信登录
     *
     * @param login 登录信息
     */
    SysTokenVO loginByMobile(SysMobileLoginVO login);

    /**
     * 发送手机验证码
     *
     * @param mobile 手机号
     */
    void sendCode(String mobile);

    /**
     * 退出登录
     *
     * @param accessToken accessToken
     */
    void logout(String accessToken);
}

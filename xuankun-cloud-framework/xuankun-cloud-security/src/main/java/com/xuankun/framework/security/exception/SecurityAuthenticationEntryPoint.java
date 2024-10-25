package com.xuankun.framework.security.exception;

import com.xuankun.framework.common.exception.ErrorCode;
import com.xuankun.framework.common.utils.HttpContextUtils;
import com.xuankun.framework.common.utils.JsonUtils;
import com.xuankun.framework.common.utils.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 匿名用户(token不存在、错误)，异常处理器
 *
 * @author Jimy
 */
public class SecurityAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
       response.setContentType("application/json; charset=utf-8");
       response.setHeader("Access-Control-Allow-Credentials", "true");
       response.setHeader("Access-Control-Allow-Origin", HttpContextUtils.getOrigin());

       response.getWriter().print(JsonUtils.toJsonString(Result.error(ErrorCode.UNAUTHORIZED)));
    }
}
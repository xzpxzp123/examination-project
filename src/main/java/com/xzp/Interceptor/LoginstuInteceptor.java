package com.xzp.Interceptor;

import com.xzp.Utils.JWTUtils;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class LoginstuInteceptor  implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler){
        String token=httpServletRequest.getHeader("token");
        if(token==null){
            throw new RuntimeException("未登录,请重新登录");
        }
        try {
            Claims claims= JWTUtils.parseJWT(token);
            String subject=claims.getSubject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("未登录,请重新登录");
        }
//        if(userType!="student"){
//            throw new RuntimeException("登录记录与当前平台不符");
//        }
        return true;
    }
}

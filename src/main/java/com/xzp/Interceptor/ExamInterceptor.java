package com.xzp.Interceptor;

import com.xzp.Mapper.ScoreMapper;
import com.xzp.Mapper.StudentMapper;
import com.xzp.Utils.JWTUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class ExamInterceptor implements HandlerInterceptor {
    @Autowired
    ScoreMapper scoreMapper;
    @Autowired
    StudentMapper studentMapper;
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler){
//        String token=httpServletRequest.getHeader("token");
        String token=httpServletRequest.getHeader("token");
        String course=httpServletRequest.getParameter("course");
        try {
          String temp_data=scoreMapper.getMaxRetakeFlagById(course,studentMapper.getNameByid(JWTUtils.parseJWT(token).getSubject()));
          if(temp_data==null){
              return true;
          }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error");
        }
        return false;
    }
}

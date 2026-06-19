package com.xzp.Config;

import com.xzp.Interceptor.LoginInteceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginInterceptorConfig implements WebMvcConfigurer {
    @Autowired
    LoginInteceptor loginInteceptor;
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(loginInteceptor)
                .addPathPatterns("/Teacher/contro/**");
    }
}

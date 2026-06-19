package com.xzp.Config;

import com.xzp.Interceptor.ExamInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ExamInterceptorConfig implements WebMvcConfigurer {
    @Autowired
    ExamInterceptor examInterceptor;
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(examInterceptor)
                .addPathPatterns("/Student/contro/show/showQuestions");
    }
}

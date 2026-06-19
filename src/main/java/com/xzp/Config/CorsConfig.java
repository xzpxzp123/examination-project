package com.xzp.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

    //前后端分离的登录检验流程：
//前端携带用户名和密码发起登录请求给后端,如果用户名和密码正确则生成一个token
//然后把生成的token通过响应返回给前端
//后期其他请求如果发行存储了token就在请求头中携带token
//    @Configuration
    public class CorsConfig implements WebMvcConfigurer {
        public void addCorsMappings(CorsRegistry registry){
//        设置允许跨域的路径
            registry.addMapping("/**")
//              设置允许跨域请求的域名
                    .allowedOrigins("*")
//              是否允许cookie
                    .allowCredentials(true)
//              设置允许的请求方式
                    .allowedMethods("GET","POST","DELETE","PUT")
//              设置允许的header属性
                    .allowedHeaders("*")
//              跨域允许时间
                    .maxAge(3600);
//      具体的含义：
//      当前端界面向后端发送put方式的跨域请求时,会先发送一个询问是否允许跨域请求的http请求
//        如果允许则会在响应头中添加相应的属性,那么在响应后的3600s后前端界面向后端发送put请求后不会再发送询问的请求
        }
    }


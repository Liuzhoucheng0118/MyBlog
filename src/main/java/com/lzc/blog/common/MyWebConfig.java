package com.lzc.blog.common;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    @Autowired
    @Qualifier(value = "loginInterceptor")
    private HandlerInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(loginInterceptor);
//        阻截
        registration.addPathPatterns("/admin/**");
//        放行
        registration.excludePathPatterns(
                "/admin/login",
                "/admin"
//                "/captcha",
//                "/user/login",
//                "/login",
//                "/user/logout",
//                "/layui/**",
//                "/lib/**",
//                "/",
//                "/js/**",
//                "/images/**",
//                "/css/**",
//                "/css/**"
        );
    }


}

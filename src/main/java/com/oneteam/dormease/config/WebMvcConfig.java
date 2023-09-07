package com.oneteam.dormease.config;

import com.oneteam.dormease.user.member.UserInterceptor;
import com.oneteam.dormease.user.parents.ParentsInterceptor;
import com.oneteam.dormease.product.ProductOrderDto;
import com.oneteam.dormease.user.student.StudentInterceptor;
import org.apache.catalina.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/dormEaseUploadImg/**")
                .addResourceLocations("file:///c://dormEase/upload/");

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new ProductOrderDto.ProductInterceptor())
                .addPathPatterns(
                        "/product/**"
                );
        registry.addInterceptor(new StudentInterceptor())
                        .addPathPatterns(
                                "/user/parents/**"
                        )
                        .excludePathPatterns( "/user/parents/createAccountForm","/user/parents/createAccountConfirm","/user/parents/loginConfirm", "/user/parents/logoutConfirm");
        registry.addInterceptor(new ParentsInterceptor())
                .addPathPatterns(
                        "/board/**", "/reply/**", "/user/student/**"
                )
                .excludePathPatterns( "/user/student/createAccountForm","/user/student/createAccountConfirm","/user/student/loginConfirm", "/user/student/searchStudents", "/user/student/logoutConfirm");
        registry.addInterceptor(new UserInterceptor())
                .addPathPatterns(
                        "/user/student/**","/notice/**", "/image/upload", "/download", "/user/parents/**"
                )
                .excludePathPatterns( "/user/parents/createAccountForm","/user/parents/createAccountConfirm","/user/parents/loginConfirm", "/user/parents/searchStudents", "/user/student/createAccountForm","/user/student/createAccountConfirm","/user/student/loginConfirm", "/user/student/searchStudents", "/user/student/logoutConfirm", "/user/parents/logoutConfirm");
    }

}

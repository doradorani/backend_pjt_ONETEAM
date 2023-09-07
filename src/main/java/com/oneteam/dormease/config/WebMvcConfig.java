package com.oneteam.dormease.config;

import com.oneteam.dormease.product.ParentsInterceptor;
import com.oneteam.dormease.user.parents.ProductInterceptor;
import com.oneteam.dormease.user.student.StudentInterceptor;
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
        registry.addInterceptor(new ProductInterceptor())
                .addPathPatterns(
                        "/product/**"
                );
        registry.addInterceptor(new StudentInterceptor())
                        .addPathPatterns(
                                "/user/student/**", "/board/**", "/reply/**", "/notice/**", "/image/upload", "/download"
                        )
                        .excludePathPatterns( "/user/student/createAccountForm","/user/student/createAccountConfirm","/user/student/loginConfirm");
        registry.addInterceptor(new ParentsInterceptor())
                .addPathPatterns(
                        "/user/parents/**", "/board/**", "/reply/**", "/notice/**", "/image/upload", "/download"
                )
                .excludePathPatterns( "/user/parents/createAccountForm","/user/parents/createAccountConfirm","/user/parents/loginConfirm", "/user/parents/searchStudents");
    }

}

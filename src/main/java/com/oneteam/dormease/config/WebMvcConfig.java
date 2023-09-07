package com.oneteam.dormease.config;

import com.oneteam.dormease.user.parents.ProductInterceptor;
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

        //유저 버전 멤버링 관련 파일은 이 밑으로  (임시로 만들어 놓음)
        //registry.addInterceptor(new StudentInterceptor())
        //                .addPathPatterns(
        //                        "/student/**"
        //                );
    }

}

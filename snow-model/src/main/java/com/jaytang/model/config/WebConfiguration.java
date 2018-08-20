package com.jaytang.model.config;

import com.jaytang.model.utils.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * spring 4的新特性
 * 采用JavaBean的形式来代替传统的xml配置文件形式进行针对框架个性化定制
 * SpringMVC相关配置。
 * 方法2️: 直接实现 WebMvcConfigurer 重写 addInterceptors方法
 */
@Configuration
public class WebConfiguration {

    @Autowired
    private MyInterceptor myInterceptor;
    @Bean
    public WebMvcConfigurer getWebMvcConfigurer(){
        /**
         * 匿名内部类
         */
        return new WebMvcConfigurer() {
            //添加注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                LogUtil.info("==========初始化拦截器");
                registry.addInterceptor(myInterceptor).addPathPatterns("/**");
            }
            //自定义静态资源映射目录
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {

            }
        };
    }
}

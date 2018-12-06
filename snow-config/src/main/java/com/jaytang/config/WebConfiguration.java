package com.jaytang.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.jaytang.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

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
         * 匿名类
         */
        return new WebMvcConfigurer() {
            //添加注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                LogUtil.debug("==========初始化拦截器");
                registry.addInterceptor(myInterceptor).addPathPatterns("/**");
            }
            //自定义静态资源映射目录
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {

            }

            /**
             * 处理返回数据格式
             * @param converters
             */
            @Override
            public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
                FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
                List<MediaType> supportedMediaTypes = new ArrayList<>();
                supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
                fastConverter.setSupportedMediaTypes(supportedMediaTypes);
                //设置WriteEnumUsingToString,对枚举的处理
                fastConverter.setFeatures(SerializerFeature.PrettyFormat,SerializerFeature.WriteEnumUsingToString);
                converters.add(fastConverter);
            }

        };
    }
}

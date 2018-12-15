package com.jaytang.config;

import com.jaytang.config.model.CustomRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro 配置类
 */
@Configuration
public class ShiroConfig {

    /**
     * 负责shiroBean的生命周期
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 注入shiro拦截器工厂类
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactory(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //设置登录url， 默认为/login.jsp 或者 /login 对应的映射
        shiroFilterFactoryBean.setLoginUrl("/login");
        //无权限时跳转的url
        shiroFilterFactoryBean.setUnauthorizedUrl("/error");
        //设置拦截器
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
        //游客，开放权限
        filterChainDefinitionMap.put("/guest/**","anon");
        //普通用户，需要角色权限 user
        filterChainDefinitionMap.put("/user/**","roles[user]");
        //管理员，需要角色 admin
        filterChainDefinitionMap.put("/admin/**","roles[admin]");
        //开放登录接口
        filterChainDefinitionMap.put("/login","anon");
        //其余接口一律拦截(次配置必须放最后，不然会拦截所有的url)
        filterChainDefinitionMap.put("/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        System.out.printf("shiro拦截工厂类注入成功");
        return shiroFilterFactoryBean;
    }

    /**
     * 注入securityManager
     * @return
     */
    @Bean
    public SecurityManager securityManager(){
        //这里很容易搞错类， 有个DefaultSecurityManager类。。。。。。。。。。。
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //设置relm
        securityManager.setRealm(customRealm());
        return securityManager;
    }

    @Bean
    public CustomRealm customRealm(){
        return new CustomRealm();
    }













}

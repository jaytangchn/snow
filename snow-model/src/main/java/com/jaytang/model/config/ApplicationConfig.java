package com.jaytang.model.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 直接使用前缀可以不用一个个加注解
 * 这里是读取properties或yml中的配置
 */
@ConfigurationProperties(prefix = "spring.datasource")
@Configuration
// @PropertySource("classpath:xxx.properties") 这里自定义读取的配置文件
public class ApplicationConfig {
//    @Value("${spring.datasource.url}")
    private String url;
 //   @Value("${spring.datasource.username}")
    private String username;
//    @Value("${spring.datasource.password}")
    private String password;
//    @Value("${spring.datasource.type}")
    private String type;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ApplicationConfig{" +
                "url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

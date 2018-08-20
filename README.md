# snow
个人搭建Java web开发框架
# 开发日志
 #### 2018/8/18:
 * 项目初始化
 * durid 2版本过低导致拿不到连接池配置。
 
 #### 2018/08/19:
 * durid 使用10的版本，解决了连接报错的问题
 * mysql 驱动版本和mysql数据库版本不匹配导致的数据库连接不上的错误
 * spring-boot-parent 移到父组件里，优化maven依赖关系。
 
 #### 2018/08/20:
 * 本地读取properties到bean
 * 启动类使用class扫描
 
 #### 还可以做的
 * 优化durid 和 mybaties 配置
 * 整合日志框架
 
 #### 注解
 * @SpringBootApplication是一个复合注解，包括@ComponentScan，和@SpringBootConfiguration，@EnableAutoConfiguration。
 * @ComponentScan，扫描当前包及其子包下被@Component，@Controller，@Service，@Repository, @Configuration注解标记的类并纳入到spring容器中进行管理。是以前的<context:component-scan> （以前使用在xml中使用的标签，用来扫描包配置的平行支持）。
 * @SpringBootConfiguration 继承自@Configuration，二者功能也一致，标注当前类是配置类，并会将当前类内声明的一个或多个以@Bean注解标记的方法的实例纳入到srping容器中
 * @Component, @Service, @Controller, @Repository是spring注解，注解后可以被spring框架所扫描并注入到spring容器来进行管理 
   @Component是通用注解，其他三个注解是这个注解的拓展，并且具有了特定的功能 
   @Repository注解在持久层中，具有将数据库操作抛出的原生异常翻译转化为spring的持久层异常的功能。 
   @Controller层是spring-mvc的注解，具有将请求进行转发，重定向的功能。 
   @Service层是业务逻辑层注解，这个注解只是标注该类处于业务逻辑层。 
 * @Configuration 中所有带 @Bean 注解的方法都会被动态代理，因此调用该方法返回的都是同一个实例。
 * @Profile注解来进行配置多环境变量,dev,uat等.
 
 #### 其他知识
  * 关于两个配置文件的知识:
     * bootstrap.yml（bootstrap.properties）用来程序引导时执行，应用于更加早期配置信息读取，如可以使用来配置application.yml中使用到参数等
     * application.yml（application.properties) 应用程序特有配置信息，可以用来配置后续各个模块中需使用的公共参数等。
     * bootstrap.yml 先于 application.yml 加载
     * properties 优先于 yml
  * java启动参数里的*--*就是对应的properties参数.
  
 
 #### 参考博客
 https://blog.csdn.net/hry2015

 http://www.spring4all.com/
 
 http://tengj.top/categories/Spring-Boot%E5%B9%B2%E8%B4%A7%E7%B3%BB%E5%88%97/
 

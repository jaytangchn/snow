package com.jaytang.app;

import com.jaytang.model.ModelScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = {ControllerScan.class, ModelScan.class,
		ServiceScan.class
})
//@EnableAutoConfiguration
//@ComponentScan
@MapperScan(basePackages = "com.jaytang.mapper") // 扫描mapper包路径  加了@Mapper注解可以不要扫描
public class SnowWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnowWebApplication.class, args);
	}


	//destroy-method="close"的作用是当数据库连接不使用的时候,就把该连接重新放到数据池中,方便下次使用调用.
//	@Bean(destroyMethod =  "close")
//	public DataSource dataSource() {
//		DruidDataSource dataSource = new DruidDataSource();
//		dataSource.setUrl("jdbc:mysql://localhost:3306/snow?useUnicode=true&characterEncoding=utf-8");
//		dataSource.setUsername("root");//用户名
//		dataSource.setPassword("123456");//密码
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setInitialSize(2);//初始化时建立物理连接的个数
//		dataSource.setMaxActive(20);//最大连接池数量
//		dataSource.setMinIdle(0);//最小连接池数量
//		dataSource.setMaxWait(60000);//获取连接时最大等待时间，单位毫秒。
//		dataSource.setValidationQuery("SELECT 1");//用来检测连接是否有效的sql
//		dataSource.setTestOnBorrow(false);//申请连接时执行validationQuery检测连接是否有效
//		dataSource.setTestWhileIdle(true);//建议配置为true，不影响性能，并且保证安全性。
//		dataSource.setPoolPreparedStatements(false);//是否缓存preparedStatement，也就是PSCache
//		return dataSource;
//	}

}

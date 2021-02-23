package com.yxs.system;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.yxs.server.mapper")
public class SystemApplication {
	private static final Logger Log= LoggerFactory.getLogger(SystemApplication.class);

	public static void main(String[] args) {
		SpringApplication app=new SpringApplication(SystemApplication.class);
		Environment env = app.run(args).getEnvironment();
		Log.info("启动成功");
		Log.info("System地址：\t http://127.0.0.1:{}",env.getProperty("server.port"));
	}
}

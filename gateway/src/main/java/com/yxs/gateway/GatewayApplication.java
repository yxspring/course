package com.yxs.gateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.cors.CorsConfiguration;

import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;

@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication {
	private static final Logger Log= LoggerFactory.getLogger(GatewayApplication.class);

	public static void main(String[] args) {
		SpringApplication app=new SpringApplication(GatewayApplication.class);
		Environment env = app.run(args).getEnvironment();
		Log.info("启动成功");
		Log.info("gateway地址：\t http://127.0.0.1:{}",env.getProperty("server.port"));
	}
	@Bean
	public CorsWebFilter corsWebFilter(){
		CorsConfiguration config=new CorsConfiguration();
		config.setAllowCredentials(Boolean.TRUE);
		config.addAllowedMethod("*");
		config.addAllowedOriginPattern("*");
		config.addAllowedHeader("*");
		config.setMaxAge(3600L);
		UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource(new PathPatternParser());
		source.registerCorsConfiguration("/**",config);
		return new CorsWebFilter(source);
	}
}

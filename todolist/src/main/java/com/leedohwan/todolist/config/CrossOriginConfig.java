package com.leedohwan.todolist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrossOriginConfig {
	// =========================================================
	// For allow cross-origin request
	// -- ip:server.port (as cross-origin): http://localhost:3000
	// -- request url mapping: all
	// -- allow method: all
	// -- by react with axios(;엑시오스) for http requset with promise
	// =========================================================
	@Bean
	public WebMvcConfigurer crosConfigurer() {
		// this is anonymous class as WebMvcConfigurer
		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
					.allowedHeaders("*")
					.allowedMethods("*")
					.allowedOrigins("*"); 
					// 크롬브라우저 확장프로그램으로 테스트하기 위해 allowedOrigins 모두 풀음
					// node server 만 풀어주려면 allowedOrigins(http://localhost:3000) 하면 됨
			}
			
		};
	}
 
}

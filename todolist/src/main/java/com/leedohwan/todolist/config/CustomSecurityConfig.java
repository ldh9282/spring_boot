package com.leedohwan.todolist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class CustomSecurityConfig {
	// Security Filter Chain
	// 1. authenticate all requests
	// 2. disable csrf token
	// 3. state-less rest api 
	// (state-less 란 용어는 세션을 안씀으로써 모든 리퀘스트가 서로 독립적이게 만든다는 뜻)
	// (세션을 사용하지 않음으로써 서버의 부하를 줄이고 서버의 로직을 세션을 생각하지 않고 간단하게 사용한다는 의도임)
	// (Rest Api 는 그저 데이터에 관한 조회, 수정, 삭제의 api 로만 사용하기 때문에 세션을 사용하지 않을 거임)

	@Bean
	public SecurityFilterChain securityFilterChain(
			HttpSecurity httpSecurity) throws Exception {
		// csrf 해제: spring version 6 부터는 람다식으로 안쓰면 deprecated 경고나옴
		// 해제 안하면 get 요청을 제외한 모든 요청(post, put, delete, patch)에 csrf 토큰값을 넣어야함
		httpSecurity.csrf(AbstractHttpConfigurer::disable);
		// 모든 요청 허락: spring version 6 부터는 람다식으로 안쓰면 deprecated 경고나옴
		httpSecurity.authorizeHttpRequests(
//				authorizeRequestsCustomizer -> authorizeRequestsCustomizer.requestMatchers("/**").permitAll()
				authorizeRequestsCustomizer -> authorizeRequestsCustomizer.anyRequest().permitAll()
		);
		// 세션 사용하지않음: spring version 6 부터는 람다식으로 안쓰면 deprecated 경고나옴
		httpSecurity.sessionManagement(
				session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		);
		
		// 디폴트 username, password 테스트: spring version 6 부터는 람다식으로 안쓰면 deprecated 경고나옴
		httpSecurity.apply(new HttpBasicConfigurer<>());
		
		return httpSecurity.build();
	}
}

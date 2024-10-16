package com.hotel.management.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityWebFilterChain(HttpSecurity httpSecurity) throws Exception{
		
		httpSecurity.authorizeHttpRequests(auth->auth.anyRequest().authenticated());
		httpSecurity.oauth2Client(Customizer.withDefaults());
		httpSecurity.oauth2ResourceServer((oauth2) -> oauth2
			    .jwt(Customizer.withDefaults()));
		
		return httpSecurity.build();
	}

}

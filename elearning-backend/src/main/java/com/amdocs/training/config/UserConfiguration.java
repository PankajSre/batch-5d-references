package com.amdocs.training.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.amdocs.training.model.User;

@Configuration
@ComponentScan(basePackages = "com.amdocs.training")
public class UserConfiguration {

	@Bean
	public User getUser() {
		return new User();
	}
}

package com.sunil.library.library.Configuration;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@ConfigurationProperties("spring.datasource")
@SuppressWarnings("unused")
public class DBConfiguration {
	
	
	private String driverClassName;
	private String url;
	private String userName;
	private String password;
	
	
	@Profile("dev")
	@Bean
	public String devDatabaseConnection() {
		
		System.out.println("DB connection for dev");
		System.out.println(driverClassName);
		System.out.println(url);
		return "DB Connection for Dev - H2";
		
	}
	
	@Profile("test")
	@Bean
	public String testDatabaseConnection() {
		
		System.out.println("DB connection for test ");
		System.out.println(driverClassName);
		System.out.println(url);
		return "DB Connection for Dev - test";
		
	}
}

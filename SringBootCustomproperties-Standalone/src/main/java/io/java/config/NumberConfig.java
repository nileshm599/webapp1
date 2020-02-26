package io.java.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "sf" , 
													transactionManagerRef = "sd"	,
													basePackages = "dfd")	
public class NumberConfig {

	public void m1() {
		System.out.println("hello....!");
	}//m1
}//class

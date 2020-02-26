package io.java.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "sf" , 
													transactionManagerRef = "sd"	,
													basePackages = "dfd")	
public class NumberConfig {

	
}//class

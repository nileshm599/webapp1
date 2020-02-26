package io.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import io.java.controller.DBController;

@SpringBootApplication
public class SringBootStandaloneTwoDatabasesConnectionApplication {

	public static void main(String[] args) {
		
		ApplicationContext ctx=SpringApplication.run(SringBootStandaloneTwoDatabasesConnectionApplication.class, args);
		DBController ctrl=ctx.getBean("dbController"  , DBController.class);
		ctrl.getData();
	}//main

}//class

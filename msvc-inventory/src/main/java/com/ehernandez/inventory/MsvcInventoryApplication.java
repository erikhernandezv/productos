package com.ehernandez.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath*:application-context.xml"})
@EnableAutoConfiguration
public class MsvcInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcInventoryApplication.class, args);
	}

}

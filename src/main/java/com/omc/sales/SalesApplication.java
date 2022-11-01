package com.omc.sales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.omc.sales.property.FileStorageProperties;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;


@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})
@ConfigurationPropertiesScan
public class SalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesApplication.class, args);
		//LOGGER.info("Welcome in SALES............");
		System.out.println("WELCOME IN SALES");
	}

}

package com.omc.sales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.omc.sales.property.FileStorageProperties;


@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})
@ConfigurationPropertiesScan
public class SalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesApplication.class, args);
		System.out.println("starting sales application.....");
	}

}

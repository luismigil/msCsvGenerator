package com.generator.csv.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsCsvGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCsvGeneratorApplication.class, args);
	}

}

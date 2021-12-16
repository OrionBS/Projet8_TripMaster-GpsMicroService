package com.tourguide.GpsMicroService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class GpsMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GpsMicroServiceApplication.class, args);
	}

}

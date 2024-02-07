package com.pk.productservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication {

	static Logger logger= LoggerFactory.getLogger(ProductServiceApplication.class);

	public static void main(String[] args) {
		logger.info("Application Started...");
		logger.info("Application Started 2nd Time");
		SpringApplication.run(ProductServiceApplication.class, args);

	}

}

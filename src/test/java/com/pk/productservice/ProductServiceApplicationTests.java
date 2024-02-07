package com.pk.productservice;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceApplicationTests {

	private final Logger logger= LoggerFactory.getLogger(ProductServiceApplicationTests.class);

	@Test
	void contextLoads() {
		logger.info("Testing...");
	}

}

package com.retail.discounts.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.retail.discounts")
public class RetaildiscountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetaildiscountsApplication.class, args);
	}

}

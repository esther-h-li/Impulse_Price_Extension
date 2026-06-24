package com.impulsepricechecker;

import com.impulsepricechecker.service.ScrapingService;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.springframework.boot.SpringApplication.run;


@SpringBootApplication
public class ImpulsePriceCheckerApplication {

	 static void main(String[] args) {
		SpringApplication.run(ImpulsePriceCheckerApplication.class, args);

	}

}

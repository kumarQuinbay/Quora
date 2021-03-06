package com.quora.searchService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SearchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchServiceApplication.class, args);
	}

}

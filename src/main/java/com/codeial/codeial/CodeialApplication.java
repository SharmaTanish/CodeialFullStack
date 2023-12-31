package com.codeial.codeial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.codeial.codeial")
@EnableJpaRepositories(basePackages = "com.codeial.codeial.repositories")
@EntityScan(basePackages = "com.codeial.codeial.entity")

public class CodeialApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeialApplication.class, args);
	}

}

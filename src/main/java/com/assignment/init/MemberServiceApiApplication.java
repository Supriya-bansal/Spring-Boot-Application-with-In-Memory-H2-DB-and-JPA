package com.assignment.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan(basePackages = {"com.assignment"})
@EnableJpaRepositories("com.assignment.repository")
@EntityScan("com.assignment.models")
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class,WebMvcAutoConfiguration.class})
@EnableWebMvc
public class MemberServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberServiceApiApplication.class, args);
	}
	
}

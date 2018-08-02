package com.piyush.bootmongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.piyush.bootmongo.*")
@SpringBootApplication
public class BootMongoApplication {

	public static void main(String[] args) {

		SpringApplication.run(BootMongoApplication.class, args);
	}
}

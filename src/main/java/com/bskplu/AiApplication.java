package com.bskplu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableCaching
@EnableAsync
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class AiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiApplication.class, args);
		System.out.println("| ---------------------------------------------------------------------------------- |");
		System.out.println("|                                    Started Success                                 |");
		System.out.println("| ---------------------------------------------------------------------------------- |");
	}

}

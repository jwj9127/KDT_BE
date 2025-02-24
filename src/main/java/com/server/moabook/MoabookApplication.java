package com.server.moabook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MoabookApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoabookApplication.class, args);
	}

}

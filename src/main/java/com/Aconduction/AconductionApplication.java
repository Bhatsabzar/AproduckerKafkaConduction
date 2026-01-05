package com.Aconduction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class AconductionApplication {

	public static void main(String[] args) {
		SpringApplication.run(AconductionApplication.class, args);
	}

}

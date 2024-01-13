package com.kafka_without_docker.testKafka;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class TestKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestKafkaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate){
		return args -> {
			kafkaTemplate.send("firstTopic", "hello world");
		};
	}
}

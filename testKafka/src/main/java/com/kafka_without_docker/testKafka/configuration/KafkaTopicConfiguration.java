package com.kafka_without_docker.testKafka.configuration;


import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.internals.Sender;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {

    @Bean
    public NewTopic firstTopic(){
        return TopicBuilder.name("firstTopic")
                .partitions(5)
                .replicas(5)
                .config(TopicConfig.RETENTION_MS_CONFIG, String.valueOf(604800000))
                .build();
    }



}

package ru.neoflex.dossier.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@RequiredArgsConstructor
public class KafkaDossierConsumerConfig {

    @Bean
    public NewTopic topicFinishRegistration() {
        return TopicBuilder.name("finish-registration")
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic topicCreateDocuments() {
        return TopicBuilder.name("create-documents")
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic topicSendDocuments() {
        return TopicBuilder.name("send-documents")
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic topicSendSes() {
        return TopicBuilder.name("send-ses")
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic topicCreditIssued() {
        return TopicBuilder.name("credit-issued")
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic topicSendApplicationDenied() {
        return TopicBuilder.name("application-denied")
                .partitions(1)
                .replicas(1)
                .build();
    }
}

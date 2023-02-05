package ru.neoflex.dossier.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class KafkaDossierConsumerConfig {

    private final KafkaProperties kafkaProperties;

    @Bean
    public Map<String, Object> consumerConfig() {
        Map<String, Object> props =
                new HashMap<>(kafkaProperties.buildProducerProperties());
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                JsonDeserializer.class);
        return props;
    }

    @Bean
    public ConsumerFactory<String, Object> consumerFactory(){
        return new DefaultKafkaConsumerFactory<>(consumerConfig());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Object>
    kafkaListenerContainerFactory() {

        ConcurrentKafkaListenerContainerFactory<String, Object> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

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

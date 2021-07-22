package com.mikebryant.kafkapoc2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.user-topic}")
    private String kafkaUserTopic;


    public void sendMessage(String message) {
        log.info("Sending message: " + message);
        kafkaTemplate.send(kafkaUserTopic, message);
    }
}

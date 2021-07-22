package com.mikebryant.kafkapoc2;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "${kafka.user-topic}", groupId = "${kafka.consumer.group-id}")
    public void consume(String message) throws IOException {
        log.info("Received message: " + message);
    }

}

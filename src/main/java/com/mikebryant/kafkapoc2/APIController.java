package com.mikebryant.kafkapoc2;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
@Slf4j
public class APIController {

    @Autowired
    private KafkaProducer kafkaProducer;


    @PostMapping(
            value = "/publish",
            consumes = MediaType.TEXT_PLAIN_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public ResponseEntity<String> sendMessageToKafkaTopic(@RequestBody String message) {
        kafkaProducer.sendMessage(message);

        return new ResponseEntity<>("", HttpStatus.OK);
    }

}

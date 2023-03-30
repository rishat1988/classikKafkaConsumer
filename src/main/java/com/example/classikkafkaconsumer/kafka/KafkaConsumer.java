package com.example.classikkafkaconsumer.kafka;

import com.example.classikkafkaconsumer.dto.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    private static final String USER_TOPIC = "${topic.name}";

    private final ObjectMapper objectMapper;

    @KafkaListener(topics = USER_TOPIC)
    public void consumeMessage(String message) throws JsonProcessingException {

        var user = objectMapper.readValue(message, User.class);
        System.out.println("succesfully got from kafka " + user);
    }

}
package com.akjn.kafka.listener;

import com.akjn.kafka.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "Kafka_Example", groupId = "group1")
    public void consume(String message){
        System.out.println("Consumed message: " + message);
    }

    @KafkaListener(topics = "Kafka_Example_Json", groupId = "group2", containerFactory = "userKafkaListenerContainerFactory")
    public void consumeJson(User user){
        System.out.println("Consumed JSON Message: " + user);
    }

}

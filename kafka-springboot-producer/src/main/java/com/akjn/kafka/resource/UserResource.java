package com.akjn.kafka.resource;

import com.akjn.kafka.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class UserResource {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate2;

    private static final String TOPIC = "Kafka_Example";
    private static final String jsonTOPIC = "Kafka_Example_Json";

    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final String name){
        kafkaTemplate.send(jsonTOPIC, new User(name,"Technology",12000L));
        return "Json published successfully!";
    }

    @GetMapping("/publishString/{name}")
    public String postString(@PathVariable("name") final String name){
        kafkaTemplate2.send(TOPIC, name);
        return "String published successfully!";
    }

}

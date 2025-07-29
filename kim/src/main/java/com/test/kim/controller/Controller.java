package com.test.kim.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final KafkaTemplate<String,String> kafkaTemplate;

    @RequestMapping("/test")
    public String test(){
        for(int i=0; i<1000; i++ ){
            kafkaTemplate.send("simpledata",String.valueOf(i)) ;
        }
            return "ok";
    }
}

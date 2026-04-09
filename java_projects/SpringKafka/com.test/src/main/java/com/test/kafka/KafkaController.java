package com.test.kafka;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/v1")
@RestController
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("message/{msg}")
    public String getMethodName(@RequestParam String param) {
      String mesage = String.format("Posted Message: %s",param);

        kafkaProducer.sendMessage("quickstart-events", mesage);
    
        return mesage;
    }
}
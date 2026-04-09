package com.test.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * 
     * @param topic
     * @param message
     */
    public void sendMessage(String topic, String message) {
        // Sends a message to the specified topic
        kafkaTemplate.send(topic, message);
    }
    
    /**
     * 
     * @param topic
     * @param key
     * @param message
     */
    public void sendMessageWithKey(String topic, String key, String message) {
        // Using a key ensures messages with the same key go to the same partition
        kafkaTemplate.send(topic, key, message);
    }
}

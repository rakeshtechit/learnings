package com.test.kafka;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(id = "eventId", topics = "quickstart-events")
	public void listen(String message) {
		System.out.println(message);
	}
}

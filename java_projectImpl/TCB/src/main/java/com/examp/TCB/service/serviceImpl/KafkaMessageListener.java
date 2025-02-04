package com.examp.TCB.service.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

	Logger log = LoggerFactory.getLogger(KafkaMessageListener.class);

	@KafkaListener(topics = "javah", groupId = "group")
	public void consume1(String message) {
		log.info("consume1 consume some message", message);	
	}

	@KafkaListener(topics = "javah", groupId = "group")
	public void consume2(String message) {
		log.info("consume2 consume some message", message);
	}

	@KafkaListener(topics = "javah", groupId = "group")
	public void consume3(String message) {
		log.info("consume3 consume some message", message);
	}

	@KafkaListener(topics = "javah", groupId = "group")
	public void consume4(String message) {
		log.info("consume4 consume some message", message);
	}

}

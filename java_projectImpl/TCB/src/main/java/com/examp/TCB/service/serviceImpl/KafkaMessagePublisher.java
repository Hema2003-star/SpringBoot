package com.examp.TCB.service.serviceImpl;

import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

@Service
public class KafkaMessagePublisher {

	@Autowired
	private KafkaTemplate<String, Object> template;

	public void sendMessageToTopic(String message) {

		CompletableFuture<SendResult<String, Object>> future = template.send("javah", message);

		// blocking the sending thread and get result about the future (we want to do it
		// in asynchronously so ..)
		future.whenComplete((result, ex) -> {

			if (ex == null) {
				System.out.println(
						"Sent message = [" + message + "] with offset = [" + result.getRecordMetadata().offset() + "]");
			} else {
				System.out.println("Unable to send message=[" + message + "] due to " + ex.getMessage());
			}
		});

	}

}

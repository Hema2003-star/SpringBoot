package com.examp.TCB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examp.TCB.service.serviceImpl.KafkaMessagePublisher;

@RestController
@RequestMapping("/producer-app")
public class EventController {

	@Autowired
	private KafkaMessagePublisher publisher;

	@GetMapping("/publish/{message}")
	public ResponseEntity<?> sendMessage(@PathVariable String message) {

		try {
			for(int i=0 ; i<10000 ; i++ ) {
			publisher.sendMessageToTopic(message + ":" + i);
			}
			return ResponseEntity.ok("message published successfully .. ");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}

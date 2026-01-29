package com.kafka.producer.service;

import com.kafka.producer.dto.OrderEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static java.lang.IO.println;

@Service
public class OrderProducer {

    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public OrderProducer(KafkaTemplate<String, OrderEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendUpdate(OrderEvent event) {
        kafkaTemplate.send("order-updates-topic", event.orderId(), event);
        println("Order update sent to topic: " + event.orderId());
    }
}
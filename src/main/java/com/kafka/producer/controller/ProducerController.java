package com.kafka.producer.controller;


import com.kafka.producer.dto.OrderEvent;
import com.kafka.producer.service.OrderProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    private final OrderProducer orderProducer;

    public ProducerController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/order")
    public void order(@RequestBody OrderEvent event) {
        orderProducer.sendUpdate(event);
    }
}

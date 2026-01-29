package com.kafka.producer.dto;

public record OrderEvent(String orderId, OrderStatus status) {}
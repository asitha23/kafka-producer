This repository contains a high-performance, reactive-ready Kafka Producer built with Spring Boot 4. It demonstrates how to integrate with Apache Kafka to send structured JSON messages using the KafkaTemplate.

🛠 Features
Spring Boot 4.x & Java 21+: Leverages Virtual Threads for lightweight concurrency.

Structured Logging: Integration-ready for observability.

JSON Serialization: Automatic POJO-to-JSON conversion via Jackson.

Dockerized Environment: Quick-start Kafka and Zookeeper setup via Docker Compose.

📋 Prerequisites
Before you begin, ensure you have the following installed:

JDK 21 or later (required for Spring Boot 4)

Maven 3.9+ or Gradle 8+

Docker & Docker Compose

⚙️ Configuration
The application is configured via src/main/resources/application.yml.

YAML
spring:
  application:
    name: kafka-producer-service
  threads:
    virtual:
      enabled: true # Spring Boot 4 focus: high-throughput messaging
  kafka:
    bootstrap-servers: localhost:9092
    producer:
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: org.springframework.kafka.support.serializer.JsonSerializer
      properties:
        spring.json.add.type.headers: false
    template:
      default-topic: sample-topic
🚀 Getting Started
1. Start Kafka Cluster
Use the provided docker-compose.yml to spin up a local broker:

Bash
docker-compose up -d
2. Build and Run
Build the application using Maven:

Bash
./mvnw clean install
./mvnw spring-boot:run
🧪 Usage & API
The producer exposes a REST endpoint to trigger message delivery.

Send a Message
Endpoint: POST /api/v1/messages

Payload:

JSON
{
  "id": "12345",
  "content": "Hello, Kafka!",
  "timestamp": "2026-01-29T20:11:00Z"
}
Example Curl:

Bash
curl -X POST http://localhost:8080/api/v1/messages \
     -H "Content-Type: application/json" \
     -d '{"id": "1", "content": "Spring Boot 4 is fast!"}'

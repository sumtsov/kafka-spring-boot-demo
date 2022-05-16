# Kafka Spring Boot Demo
Sample project that demonstrates how to use Apache Kafka in a Spring Boot application

## How to run 
1) Build [kafka-client](kafka-client/) by executing `mvn clean install`
2) Build docker images by executing `mvn compile jib:dockerBuild` for:
   - [kafka-producer-service](kafka-producer-service/)
   - [kafka-consumer-service](kafka-consumer-service/)
3) Start docker containers: `docker-compose up -d`

## Usage
- Send message to Kafka: `http://localhost:8080/swagger-ui/index.html#/kafka-controller/send`
- Check order_status topic messages:
```
docker exec --interactive --tty kafka \
kafka-console-consumer --bootstrap-server kafka:9092 \
                       --topic order_status \ 
                       --from-beginning
```
- Check kafka-consumer-service logs: `docker logs kafka-consumer-service 2>&1 | grep 'Listener received:'`

## API Reference
- swagger-ui: `http://localhost:8080/swagger-ui/index.html`
- json: `http://localhost:8080/v3/api-docs`
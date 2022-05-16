package com.dsumtsov.kafka.producer.controller;

import com.dsumtsov.kafka.client.dto.OrderStatusUpdateDTO;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/kafka")
public class KafkaController {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Operation(summary = "Send message to order_status topic")
    @PostMapping("/send")
    public OrderStatusUpdateDTO send(@RequestBody OrderStatusUpdateDTO message) {
        log.info("Sending message to order_status topic");
        kafkaTemplate.send("order_status", message);
        return message;
    }
}

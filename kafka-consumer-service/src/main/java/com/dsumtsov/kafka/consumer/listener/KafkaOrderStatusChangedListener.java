package com.dsumtsov.kafka.consumer.listener;

import com.dsumtsov.kafka.client.dto.OrderStatusUpdateDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaOrderStatusChangedListener {

    @KafkaListener(
            topics = "order_status",
            groupId = "group-id",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void onMessageReceived(OrderStatusUpdateDTO message) {
        log.info("Listener received: {}", message);
    }
}

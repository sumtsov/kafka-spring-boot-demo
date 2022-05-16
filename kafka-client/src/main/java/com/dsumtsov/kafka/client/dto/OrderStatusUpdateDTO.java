package com.dsumtsov.kafka.client.dto;

import com.dsumtsov.kafka.client.enums.OrderStatus;
import lombok.Data;

@Data
public class OrderStatusUpdateDTO {
    private Long orderId;
    private OrderStatus newStatus;
    private OrderStatus prevStatus;
}

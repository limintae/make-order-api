package com.github.prgrms.orders.model;

import com.github.prgrms.products.enums.OrderStatus;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class OrderDto {

    private Long id;
    private Long productSeq;
    private ReviewDto review;
    private OrderStatus state;
    private String requestMessage;
    private String rejectMessage;
    private LocalDateTime completedAt;
    private LocalDateTime rejectedAt;
    private LocalDateTime createAt;



}

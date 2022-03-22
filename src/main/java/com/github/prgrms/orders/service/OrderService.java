package com.github.prgrms.orders.service;

import com.github.prgrms.orders.entity.Order;
import com.github.prgrms.orders.model.response.OrderResponse;
import com.github.prgrms.orders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public List<OrderResponse> findAll(Long userSeq, Pageable pageable) {
        Page<Order> po = orderRepository.findByUserSeqOrderBySeqDesc(userSeq, pageable);
        List<OrderResponse> list = po.stream().map(OrderResponse::of).toList();
        return list;
    }

    public OrderResponse findByUserOrder(Long userSeq, Long orderSeq) {
        return OrderResponse.of(orderRepository.findBySeqAndUserSeq(orderSeq, userSeq)
                .orElseThrow(() -> new IllegalArgumentException("주문번호를 찾을 수 없습니다."))
        );
    }

}

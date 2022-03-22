package com.github.prgrms.orders.service;

import com.github.prgrms.orders.entity.Order;
import com.github.prgrms.orders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public void findAll(Long id, Pageable pageable) {
        Page<Order> po = orderRepository.findByUserSeqOrderByIdDesc(id, pageable);
        System.out.println(po.getTotalElements());
    }

}

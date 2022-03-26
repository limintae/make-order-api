package com.github.prgrms.orders.adapter.persistence;

import com.github.prgrms.annotations.Adapter;
import com.github.prgrms.orders.application.port.persistence.ReadOrderPort;
import com.github.prgrms.orders.adapter.persistence.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Adapter
@RequiredArgsConstructor
public class ReadOrderAdapter implements ReadOrderPort {

    private final OrderRepository orderRepository;

    @Override
    public Page<Order> findByUserSeqOrderBySeqDesc(Long id, Pageable pageable) {
        return orderRepository.findByUserSeqOrderBySeqDesc(id, pageable);
    }

    @Override
    public Optional<Order> findBySeqAndUserSeq(Long orderId, Long userSeq) {
        return orderRepository.findBySeqAndUserSeq(orderId, userSeq);
    }

}

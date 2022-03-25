package com.github.prgrms.orders.application;

import com.github.prgrms.orders.application.port.in.OrderReadOnlyUseCase;
import com.github.prgrms.orders.adapter.in.response.OrderResponse;
import com.github.prgrms.orders.adapter.out.persistence.OrderPersistenceAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService implements OrderReadOnlyUseCase {

    private final OrderPersistenceAdapter orderPersistenceAdapter;

    @Override
    @Transactional(readOnly = true)
    public List<OrderResponse> findAll(Long userSeq, Pageable pageable) {
        return orderPersistenceAdapter.findByUserSeqOrderBySeqDesc(userSeq, pageable).stream().map(OrderResponse::of).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public OrderResponse findByUserOrder(Long userSeq, Long orderSeq) {
        return OrderResponse.of(orderPersistenceAdapter.findBySeqAndUserSeq(orderSeq, userSeq)
                .orElseThrow(() -> new IllegalArgumentException("주문번호를 찾을 수 없습니다."))
        );
    }

}

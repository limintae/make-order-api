package com.github.prgrms.orders.application.service;

import com.github.prgrms.orders.application.port.persistence.ReadOrderPort;
import com.github.prgrms.orders.application.usecase.FindOrderUseCase;
import com.github.prgrms.orders.adapter.entrypoint.api.model.response.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FindOrderService implements FindOrderUseCase {

    private final ReadOrderPort readOrderPort;

    @Override
    @Transactional(readOnly = true)
    public List<OrderResponse> findAll(Long userSeq, Pageable pageable) {
        return readOrderPort.findByUserSeqOrderBySeqDesc(userSeq, pageable).stream().map(OrderResponse::of).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public OrderResponse findByUserOrder(Long userSeq, Long orderSeq) {
        return OrderResponse.of(readOrderPort.findBySeqAndUserSeq(orderSeq, userSeq)
                .orElseThrow(() -> new IllegalArgumentException("주문번호를 찾을 수 없습니다."))
        );
    }

}
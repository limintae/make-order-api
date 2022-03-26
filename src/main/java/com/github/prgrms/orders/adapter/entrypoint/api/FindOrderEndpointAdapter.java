package com.github.prgrms.orders.adapter.entrypoint.api;

import com.github.prgrms.annotations.Adapter;
import com.github.prgrms.orders.adapter.entrypoint.api.model.response.OrderResponse;
import com.github.prgrms.orders.application.port.entrypoint.api.FindOrderEndpointPort;
import com.github.prgrms.orders.application.usecase.FindOrderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RequiredArgsConstructor
@Adapter
public class FindOrderEndpointAdapter implements FindOrderEndpointPort {

    private final FindOrderUseCase findOrderUseCase;

    @Override
    public List<OrderResponse> findAll(Long userSeq, Pageable pageable) {
        return findOrderUseCase.findAll(userSeq, pageable);
    }

    @Override
    public OrderResponse findByUserOrder(Long userSeq, Long orderSeq) {
        return findOrderUseCase.findByUserOrder(userSeq, orderSeq);
    }

}

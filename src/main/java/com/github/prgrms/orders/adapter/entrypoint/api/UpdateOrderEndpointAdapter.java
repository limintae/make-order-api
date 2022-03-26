package com.github.prgrms.orders.adapter.entrypoint.api;

import com.github.prgrms.annotations.Adapter;
import com.github.prgrms.orders.application.port.entrypoint.api.UpdateOrderEndpointPort;
import com.github.prgrms.orders.application.usecase.UpdateOrderUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Adapter
public class UpdateOrderEndpointAdapter implements UpdateOrderEndpointPort {

    private final UpdateOrderUseCase updateOrderUseCase;

    @Override
    public boolean acceptOrder(Long userSeq, Long orderSeq) {
        return updateOrderUseCase.acceptOrder(userSeq, orderSeq);
    }

}

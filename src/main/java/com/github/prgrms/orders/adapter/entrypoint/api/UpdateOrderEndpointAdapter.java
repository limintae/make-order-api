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
    public boolean requestedToAcceptOrder(Long userSeq, Long orderSeq) {
        return updateOrderUseCase.requestedToAcceptOrder(userSeq, orderSeq);
    }

    @Override
    public boolean acceptToShippingOrder(Long userSeq, Long orderSeq) {
        return updateOrderUseCase.acceptToShippingOrder(userSeq, orderSeq);
    }

    @Override
    public boolean requestedToRejectOrder(Long userSeq, Long orderSeq, String rejectMessage) {
        return updateOrderUseCase.requestedToRejectOrder(userSeq, orderSeq, rejectMessage);
    }

    @Override
    public boolean shippingToCompleteOrder(Long userSeq, Long orderSeq) {
        return updateOrderUseCase.shippingToCompleteOrder(userSeq, orderSeq);
    }
}

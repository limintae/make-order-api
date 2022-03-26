package com.github.prgrms.orders.application.usecase;

public interface UpdateOrderUseCase {
    boolean requestedToAcceptOrder(Long userSeq, Long orderSeq);
    boolean acceptToShippingOrder(Long userSeq, Long orderSeq);
    boolean requestedToRejectOrder(Long userSeq, Long orderSeq, String rejectMessage);
    boolean shippingToCompleteOrder(Long userSeq, Long orderSeq);
}

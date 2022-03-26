package com.github.prgrms.orders.application.usecase;

public interface UpdateOrderUseCase {
    boolean acceptOrder(Long userSeq, Long orderSeq);
}

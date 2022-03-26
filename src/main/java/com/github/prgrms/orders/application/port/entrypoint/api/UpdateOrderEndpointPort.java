package com.github.prgrms.orders.application.port.entrypoint.api;

public interface UpdateOrderEndpointPort {
    boolean acceptOrder(Long userSeq, Long orderSeq);
}

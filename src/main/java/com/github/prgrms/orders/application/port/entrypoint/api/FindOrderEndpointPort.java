package com.github.prgrms.orders.application.port.entrypoint.api;

import com.github.prgrms.orders.adapter.entrypoint.api.model.response.OrderResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FindOrderEndpointPort {

    List<OrderResponse> findAll(Long userSeq, Pageable pageable);
    OrderResponse findByUserOrder(Long userSeq, Long orderSeq);

}

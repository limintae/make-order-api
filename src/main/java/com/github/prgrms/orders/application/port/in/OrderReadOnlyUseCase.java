package com.github.prgrms.orders.application.port.in;

import com.github.prgrms.orders.adapter.in.response.OrderResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderReadOnlyUseCase {

    List<OrderResponse> findAll(Long userSeq, Pageable pageable);
    OrderResponse findByUserOrder(Long userSeq, Long orderSeq);

}

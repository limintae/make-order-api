package com.github.prgrms.orders.application.usecase;

import com.github.prgrms.orders.adapter.entrypoint.api.model.response.OrderResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FindOrderUseCase {

    List<OrderResponse> findAll(Long userSeq, Pageable pageable);
    OrderResponse findByUserOrder(Long userSeq, Long orderSeq);

}

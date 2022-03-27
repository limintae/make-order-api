package com.github.prgrms.orders.application.service;

import com.github.prgrms.errors.NotFoundException;
import com.github.prgrms.orders.adapter.entrypoint.api.model.response.ReviewResponse;
import com.github.prgrms.orders.adapter.persistence.model.Order;
import com.github.prgrms.orders.application.port.persistence.ReadOrderPort;
import com.github.prgrms.orders.application.usecase.FindReviewUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FindReviewService implements FindReviewUseCase {

    private final ReadOrderPort readOrderPort;

    @Override
    public ReviewResponse findReviewFromOrder(Long userSeq, Long orderSeq) {
        Order order = readOrderPort.findBySeqAndUserSeq(orderSeq, userSeq)
                .orElseThrow(() -> new NotFoundException("주문에 리뷰가 존재하지않습니다."));
        return ReviewResponse.of(order.getReview());
    }
}

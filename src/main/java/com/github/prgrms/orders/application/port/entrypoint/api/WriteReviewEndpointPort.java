package com.github.prgrms.orders.application.port.entrypoint.api;

import com.github.prgrms.orders.adapter.entrypoint.api.model.response.ReviewResponse;

public interface WriteReviewEndpointPort {
    ReviewResponse writeReviewFromOrder(Long userSeq, Long orderSeq, String content);
    ReviewResponse findReviewFromOrder(Long userSeq, Long orderSeq);
}

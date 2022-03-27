package com.github.prgrms.orders.application.usecase;

import com.github.prgrms.orders.adapter.entrypoint.api.model.response.ReviewResponse;

public interface WriteReviewUseCase {
    ReviewResponse writeReviewFromOrder(Long userSeq, Long orderSeq, String content);
}

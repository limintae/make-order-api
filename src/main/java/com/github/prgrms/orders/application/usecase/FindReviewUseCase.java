package com.github.prgrms.orders.application.usecase;

import com.github.prgrms.orders.adapter.entrypoint.api.model.response.ReviewResponse;

public interface FindReviewUseCase {
    ReviewResponse findReviewFromOrder(Long userSeq, Long orderSeq);
}

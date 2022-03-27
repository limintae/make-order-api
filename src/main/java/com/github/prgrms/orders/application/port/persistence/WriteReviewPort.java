package com.github.prgrms.orders.application.port.persistence;

import com.github.prgrms.orders.adapter.persistence.model.Review;

public interface WriteReviewPort {
    Review writeReviewFromOrder(Review review);
}

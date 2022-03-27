package com.github.prgrms.orders.adapter.persistence;

import com.github.prgrms.annotations.Adapter;
import com.github.prgrms.orders.adapter.persistence.model.Review;
import com.github.prgrms.orders.application.port.persistence.WriteReviewPort;
import lombok.RequiredArgsConstructor;

@Adapter
@RequiredArgsConstructor
public class WriteReviewAdapter implements WriteReviewPort {

    private final ReviewRepository reviewRepository;

    @Override
    public Review writeReviewFromOrder(Review review) {
        return reviewRepository.save(review);
    }

}

package com.github.prgrms.orders.application.service;

import com.github.prgrms.errors.NotFoundException;
import com.github.prgrms.orders.adapter.entrypoint.api.model.response.ReviewResponse;
import com.github.prgrms.orders.adapter.persistence.model.Order;
import com.github.prgrms.orders.adapter.persistence.model.Review;
import com.github.prgrms.orders.application.enums.OrderStatus;
import com.github.prgrms.orders.application.port.persistence.ReadOrderPort;
import com.github.prgrms.orders.application.port.persistence.UpdateOrderPort;
import com.github.prgrms.orders.application.port.persistence.WriteReviewPort;
import com.github.prgrms.orders.application.usecase.WriteReviewUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class WriteReviewService implements WriteReviewUseCase {

    private final ReadOrderPort readOrderPort;
    private final UpdateOrderPort updateOrderPort;
    private final WriteReviewPort writeReviewPort;

    @Transactional
    @Override
    public ReviewResponse writeReviewFromOrder(Long userSeq, Long orderSeq, String content) {
        Order order = readOrderPort.findBySeqAndUserSeq(orderSeq, userSeq)
                .orElseThrow(() -> new NotFoundException("order not founded"));

        if (order.getState() == OrderStatus.COMPLETED) {
            if (order.getReviewSeq() != null) {
                // 리뷰가 등록되어있다면 등록하지 못함
                throw new IllegalStateException("review already exist");
            }
            Review writeReview = writeReviewPort.writeReviewFromOrder(
                    Review.of(userSeq, order.getProductSeq(), content)
            );
            order.setReviewSeq(writeReview.getSeq());
            order.setReview(writeReview);
            order.getProduct().addReviewCount();
            updateOrderPort.updateOrderStatus(order);
            return ReviewResponse.of(order.getReview());
        } else {
            throw new IllegalStateException("order is not REQUESTED");
        }
    }

}

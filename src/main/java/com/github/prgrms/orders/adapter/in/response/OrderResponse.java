package com.github.prgrms.orders.adapter.in.response;

import com.github.prgrms.orders.domain.Order;
import com.github.prgrms.products.enums.OrderStatus;
import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDateTime;

@Getter
public class OrderResponse {

    private final Long seq;
    private final Long productId;
    private final ReviewResponse review;
    private final OrderStatus state;
    private final String requestMessage;
    private final String rejectMessage;
    private final LocalDateTime completedAt;
    private final LocalDateTime rejectedAt;
    private final LocalDateTime createAt;

    @Builder
    public OrderResponse(
            Long seq,
            Long productId,
            ReviewResponse review,
            OrderStatus state,
            String requestMessage,
            String rejectMessage,
            LocalDateTime completedAt,
            LocalDateTime rejectedAt,
            LocalDateTime createAt
    ) {
        this.seq = seq;
        this.productId = productId;
        this.review = review;
        this.state = state;
        this.requestMessage = requestMessage;
        this.rejectMessage = rejectMessage;
        this.completedAt = completedAt;
        this.rejectedAt = rejectedAt;
        this.createAt = createAt;
    }

    public static OrderResponse of(Order order) {
        return OrderResponse.builder()
                .seq(order.getSeq())
                .productId(order.getProductSeq())
                .review((order.getReview() != null) ? ReviewResponse.of(order.getReview()) : null)
                .state(order.getState())
                .requestMessage(order.getRequestMsg())
                .rejectMessage(order.getRejectMsg())
                .completedAt(order.getCompletedAt())
                .rejectedAt(order.getRejectedAt())
                .createAt(order.getCreateAt())
                .build();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("seq", seq)
                .append("productId", productId)
                .append("state", state.toString())
                .append("rejectMessage", rejectMessage)
                .append("rejectedAt", rejectedAt)
                .append("completedAt", completedAt)
                .toString();
    }

}

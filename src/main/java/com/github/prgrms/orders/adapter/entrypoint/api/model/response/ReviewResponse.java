package com.github.prgrms.orders.adapter.entrypoint.api.model.response;

import com.github.prgrms.review.entity.Review;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReviewResponse {

    private final Long seq;
    private final Long productId;
    private final String content;
    private final LocalDateTime createAt;

    @Builder
    public ReviewResponse(Long seq, Long productId, String content, LocalDateTime createAt) {
        this.seq = seq;
        this.productId = productId;
        this.content = content;
        this.createAt = createAt;
    }

    static ReviewResponse of(Review source) {
        return ReviewResponse.builder()
                .seq(source.getSeq())
                .productId(source.getProductSeq())
                .content(source.getContent())
                .createAt(source.getCreateAt())
                .build();
    }

}

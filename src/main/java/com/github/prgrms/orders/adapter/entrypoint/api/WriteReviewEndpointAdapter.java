package com.github.prgrms.orders.adapter.entrypoint.api;

import com.github.prgrms.annotations.Adapter;
import com.github.prgrms.orders.adapter.entrypoint.api.model.response.ReviewResponse;
import com.github.prgrms.orders.application.port.entrypoint.api.WriteReviewEndpointPort;
import com.github.prgrms.orders.application.usecase.FindReviewUseCase;
import com.github.prgrms.orders.application.usecase.WriteReviewUseCase;
import lombok.RequiredArgsConstructor;

@Adapter
@RequiredArgsConstructor
public class WriteReviewEndpointAdapter implements WriteReviewEndpointPort {

    private final WriteReviewUseCase writeReviewUseCase;
    private final FindReviewUseCase findReviewUseCase;

    @Override
    public ReviewResponse writeReviewFromOrder(Long userSeq, Long orderSeq, String content) {
        return writeReviewUseCase.writeReviewFromOrder(userSeq, orderSeq, content);
    }

    @Override
    public ReviewResponse findReviewFromOrder(Long userSeq, Long orderSeq) {
        return findReviewUseCase.findReviewFromOrder(userSeq, orderSeq);
    }

}

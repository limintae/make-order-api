package com.github.prgrms.orders.adapter.entrypoint.api.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class WriteReviewRequest {

    @NotNull
    @Size(max = 1000)
    private String content;

    @Builder
    public WriteReviewRequest(String content) {
        this.content = content;
    }

}

package com.github.prgrms.orders.adapter.entrypoint.api.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class RejectRequest {

    @NotNull
    private String message;

    @Builder
    public RejectRequest(String message) {
        this.message = message;
    }

}

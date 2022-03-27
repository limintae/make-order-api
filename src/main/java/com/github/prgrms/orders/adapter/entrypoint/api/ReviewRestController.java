package com.github.prgrms.orders.adapter.entrypoint.api;

import com.github.prgrms.orders.adapter.entrypoint.api.model.request.WriteReviewRequest;
import com.github.prgrms.orders.adapter.entrypoint.api.model.response.ReviewResponse;
import com.github.prgrms.security.token.JwtAuthentication;
import com.github.prgrms.utils.ApiUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.github.prgrms.utils.ApiUtils.success;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/orders")
public class ReviewRestController {

    private final WriteReviewEndpointAdapter writeReviewEndpointAdapter;

    @PostMapping(path = "{id}/review")
    public ApiUtils.ApiResult<ReviewResponse> review(
            @AuthenticationPrincipal JwtAuthentication authentication,
            @PathVariable(name = "id") Long orderId,
            @Valid @RequestBody WriteReviewRequest request) {
        return success(writeReviewEndpointAdapter.writeReviewFromOrder(authentication.id, orderId, request.getContent()));
    }

}
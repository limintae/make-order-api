package com.github.prgrms.orders.adapter.entrypoint.api;

import com.github.prgrms.configures.web.SimplePageRequest;
import com.github.prgrms.orders.adapter.entrypoint.api.model.request.RejectRequest;
import com.github.prgrms.orders.adapter.entrypoint.api.model.response.OrderResponse;
import com.github.prgrms.security.token.JwtAuthentication;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.github.prgrms.utils.ApiUtils.ApiResult;
import static com.github.prgrms.utils.ApiUtils.success;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/orders")
public class OrderRestController {
    // TODO findAll, findById, accept, reject, shipping, complete 메소드 구현이 필요합니다.

    private final FindOrderEndpointAdapter findOrderEndpointAdapter;
    private final UpdateOrderEndpointAdapter updateOrderEndpointAdapter;

    /**
     * 모든 주문 목록 조회
     * @param authentication
     * @return
     */
    @GetMapping
    public ApiResult<List<OrderResponse>> findAll(
            @AuthenticationPrincipal JwtAuthentication authentication,
            SimplePageRequest simplePageRequest) {
        Pageable pageable = PageRequest.of((int) simplePageRequest.getOffset(), simplePageRequest.getSize());
        return success(findOrderEndpointAdapter.findAll(authentication.id, pageable));
    }

    /**
     * 주문 조회
     * @param authentication
     * @param orderId
     * @return
     */
    @GetMapping(path = "{id}")
    public ApiResult<OrderResponse> findById(
            @AuthenticationPrincipal JwtAuthentication authentication,
            @PathVariable(name = "id") Long orderId) {
        return success(findOrderEndpointAdapter.findByUserOrder(authentication.id, orderId));
    }

    /**
     * 주문 접수처리
     * @param authentication
     * @param orderId
     * @return
     */
    @PatchMapping(path = "{id}/accept")
    public ApiResult<Boolean> accept(
            @AuthenticationPrincipal JwtAuthentication authentication,
            @PathVariable(name = "id") Long orderId) {
        return success(updateOrderEndpointAdapter.requestedToAcceptOrder(authentication.id, orderId));
    }

    /**
     * 주문 배송 처리
     * @param authentication
     * @param orderId
     * @return
     */
    @PatchMapping(path = "{id}/shipping")
    public ApiResult<Boolean> shipping(
            @AuthenticationPrincipal JwtAuthentication authentication,
            @PathVariable(name = "id") Long orderId) {
        return success(updateOrderEndpointAdapter.acceptToShippingOrder(authentication.id, orderId));
    }

    /**
     * 주문 거절 처리
     * @param authentication
     * @param orderId
     * @param rejectRequest
     * @return
     */
    @PatchMapping(path = "{id}/reject")
    public ApiResult<Boolean> reject(
            @AuthenticationPrincipal JwtAuthentication authentication,
            @PathVariable(name = "id") Long orderId,
            @Valid @RequestBody RejectRequest rejectRequest) {
        return success(updateOrderEndpointAdapter.requestedToRejectOrder(
                authentication.id,
                orderId,
                rejectRequest.getMessage()
        ));
    }

    /**
     * 주문 완료 처리
     * @param authentication
     * @param orderId
     * @return
     */
    @PatchMapping(path = "{id}/complete")
    public ApiResult<Boolean> complete(
            @AuthenticationPrincipal JwtAuthentication authentication,
            @PathVariable(name = "id") Long orderId) {
        return success(updateOrderEndpointAdapter.shippingToCompleteOrder(
                authentication.id,
                orderId
        ));
    }

}
package com.github.prgrms.orders.adapter.in;

import com.github.prgrms.configures.web.SimplePageRequest;
import com.github.prgrms.orders.adapter.in.response.OrderResponse;
import com.github.prgrms.orders.application.OrderService;
import com.github.prgrms.security.token.JwtAuthentication;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.github.prgrms.utils.ApiUtils.ApiResult;
import static com.github.prgrms.utils.ApiUtils.success;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/orders")
public class OrderRestController {
    // TODO findAll, findById, accept, reject, shipping, complete 메소드 구현이 필요합니다.

    private final OrderService orderService;

    /**
     * 주문 목록 조회
     * @param authentication
     * @return
     */
    @GetMapping
    public ApiResult<List<OrderResponse>> findAll(
            @AuthenticationPrincipal JwtAuthentication authentication,
            SimplePageRequest simplePageRequest) {
        Pageable pageable = PageRequest.of((int) simplePageRequest.getOffset(), simplePageRequest.getSize());
        return success(orderService.findAll(authentication.id, pageable));
    }

    @GetMapping(path = "{id}")
    public ApiResult<OrderResponse> findById(
            @AuthenticationPrincipal JwtAuthentication authentication,
            @PathVariable(name = "id") Long id) {
        return success(orderService.findByUserOrder(authentication.id, id));
    }

}
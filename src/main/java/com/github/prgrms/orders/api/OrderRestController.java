package com.github.prgrms.orders.api;

import com.github.prgrms.configures.web.SimplePageRequest;
import com.github.prgrms.orders.service.OrderService;
import com.github.prgrms.security.token.JwtAuthentication;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public String findAll(
            @AuthenticationPrincipal JwtAuthentication authentication,
            SimplePageRequest simplePageRequest) {
        Pageable pageable = PageRequest.of((int) simplePageRequest.getOffset(), simplePageRequest.getSize());
        orderService.findAll(authentication.id, pageable);
        return authentication.name;
    }

}
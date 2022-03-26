package com.github.prgrms.orders.adapter.persistence;

import com.github.prgrms.annotations.Adapter;
import com.github.prgrms.orders.adapter.persistence.model.Order;
import com.github.prgrms.orders.application.port.persistence.UpdateOrderPort;
import lombok.RequiredArgsConstructor;

@Adapter
@RequiredArgsConstructor
public class UpdateOrderAdapter implements UpdateOrderPort {

    private final OrderRepository orderRepository;

    @Override
    public void updateOrderStatus(Order order) {
        orderRepository.save(order);
    }

}

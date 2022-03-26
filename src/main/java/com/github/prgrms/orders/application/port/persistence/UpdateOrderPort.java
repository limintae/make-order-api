package com.github.prgrms.orders.application.port.persistence;

import com.github.prgrms.orders.adapter.persistence.model.Order;

public interface UpdateOrderPort {
    void updateOrderStatus(Order order);
}

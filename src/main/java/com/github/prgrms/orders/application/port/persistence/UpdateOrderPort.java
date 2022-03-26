package com.github.prgrms.orders.application.port.persistence;

import com.github.prgrms.orders.adapter.persistence.model.Order;
import com.github.prgrms.orders.application.enums.OrderStatus;

public interface UpdateOrderPort {
    void updateOrderStatus(Order order);
}

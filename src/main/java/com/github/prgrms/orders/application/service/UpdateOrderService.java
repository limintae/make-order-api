package com.github.prgrms.orders.application.service;

import com.github.prgrms.errors.NotFoundException;
import com.github.prgrms.orders.adapter.persistence.model.Order;
import com.github.prgrms.orders.application.enums.OrderStatus;
import com.github.prgrms.orders.application.port.persistence.ReadOrderPort;
import com.github.prgrms.orders.application.port.persistence.UpdateOrderPort;
import com.github.prgrms.orders.application.usecase.UpdateOrderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateOrderService implements UpdateOrderUseCase {

    private final ReadOrderPort readOrderPort;
    private final UpdateOrderPort updateOrderPort;

    @Transactional
    @Override
    public boolean requestedToAcceptOrder(Long userSeq, Long orderSeq) {
        Order order = readOrderPort.findBySeqAndUserSeq(orderSeq, userSeq)
                .orElseThrow(() -> new NotFoundException("order not founded"));

        if (order.getState() == OrderStatus.REQUESTED) {
            order.setState(OrderStatus.ACCEPTED);
            updateOrderPort.updateOrderStatus(order);
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public boolean acceptToShippingOrder(Long userSeq, Long orderSeq) {
        Order order = readOrderPort.findBySeqAndUserSeq(orderSeq, userSeq)
                .orElseThrow(() -> new NotFoundException("order not founded"));

        if (order.getState() == OrderStatus.ACCEPTED) {
            order.setState(OrderStatus.SHIPPING);
            updateOrderPort.updateOrderStatus(order);
            return true;
        }
        return false;
    }

    @Override
    public boolean requestedToRejectOrder(Long userSeq, Long orderSeq, String rejectMessage) {
        Order order = readOrderPort.findBySeqAndUserSeq(orderSeq, userSeq)
                .orElseThrow(() -> new NotFoundException("order not founded"));

        if (order.getState() == OrderStatus.REQUESTED) {
            order.setState(OrderStatus.REJECTED);
            order.setRejectMsg(rejectMessage);
            updateOrderPort.updateOrderStatus(order);
            return true;
        }
        return false;
    }

    @Override
    public boolean shippingToCompleteOrder(Long userSeq, Long orderSeq) {
        Order order = readOrderPort.findBySeqAndUserSeq(orderSeq, userSeq)
                .orElseThrow(() -> new NotFoundException("order not founded"));

        if (order.getState() == OrderStatus.SHIPPING) {
            order.setState(OrderStatus.COMPLETED);
            updateOrderPort.updateOrderStatus(order);
            return true;
        }
        return false;
    }

}

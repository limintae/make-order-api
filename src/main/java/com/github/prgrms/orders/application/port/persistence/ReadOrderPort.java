package com.github.prgrms.orders.application.port.persistence;

import com.github.prgrms.orders.adapter.persistence.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ReadOrderPort {

    Page<Order> findByUserSeqOrderBySeqDesc(Long id, Pageable pageable);
    Optional<Order> findBySeqAndUserSeq(Long orderSeq, Long userSeq);

}

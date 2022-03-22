package com.github.prgrms.orders.repository;

import com.github.prgrms.orders.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Page<Order> findByUserSeqOrderByIdDesc(Long id, Pageable pageable);

}

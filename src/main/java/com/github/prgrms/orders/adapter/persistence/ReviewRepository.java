package com.github.prgrms.orders.adapter.persistence;

import com.github.prgrms.orders.adapter.persistence.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}

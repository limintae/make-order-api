package com.github.prgrms.products.adapter.persistence;

import com.github.prgrms.products.adapter.persistence.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
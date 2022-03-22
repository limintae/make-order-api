package com.github.prgrms.products.repository;

import com.github.prgrms.products.entity.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
  Optional<Product> findById(long id);
  List<Product> findAll();
}
package com.github.prgrms.products.application.port.persistence;

import com.github.prgrms.products.adapter.entrypoint.api.model.response.ProductDto;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface FindProductPort {
    ProductDto findProductById(Long productId);
    List<ProductDto> findAllProducts(Sort.Direction sort, String sortedField);
}

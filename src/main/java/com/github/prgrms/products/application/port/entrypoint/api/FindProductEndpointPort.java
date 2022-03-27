package com.github.prgrms.products.application.port.entrypoint.api;

import com.github.prgrms.products.adapter.entrypoint.api.model.response.ProductDto;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface FindProductEndpointPort {
    ProductDto findProductById(Long productId);
    List<ProductDto> findAllProducts(Sort.Direction sort, String sortedField);
}

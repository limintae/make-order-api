package com.github.prgrms.products.adapter.persistence;

import com.github.prgrms.annotations.Adapter;
import com.github.prgrms.errors.NotFoundException;
import com.github.prgrms.products.adapter.entrypoint.api.model.response.ProductDto;
import com.github.prgrms.products.adapter.persistence.model.Product;
import com.github.prgrms.products.application.port.persistence.FindProductPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Adapter
public class FindProductAdapter implements FindProductPort {

    private final ProductRepository productRepository;

    @Override
    public ProductDto findProductById(Long productId) {
        return ProductDto.of(productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Could not found product for " + productId)));
    }

    @Override
    public List<ProductDto> findAllProducts(Sort.Direction sort, String sortedField) {
        return productRepository.findAll(Sort.by(sort, sortedField))
                .stream()
                .map(ProductDto::of)
                .collect(Collectors.toList());
    }

}

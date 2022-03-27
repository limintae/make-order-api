package com.github.prgrms.products.adapter.entrypoint.api;

import com.github.prgrms.annotations.Adapter;
import com.github.prgrms.products.adapter.entrypoint.api.model.response.ProductDto;
import com.github.prgrms.products.application.port.entrypoint.api.FindProductEndpointPort;
import com.github.prgrms.products.application.usecase.FindProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;

import java.util.List;

@RequiredArgsConstructor
@Adapter
public class FindProductEndpointAdapter implements FindProductEndpointPort {

    private final FindProductUseCase findProductUseCase;

    @Override
    public ProductDto findProductById(Long productId) {
        return findProductUseCase.findProductById(productId);
    }

    @Override
    public List<ProductDto> findAllProducts(Sort.Direction sort, String sortedField) {
        return findProductUseCase.findAllProducts(sort, sortedField);
    }

}

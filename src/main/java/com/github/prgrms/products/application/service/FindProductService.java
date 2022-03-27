package com.github.prgrms.products.application.service;

import com.github.prgrms.products.adapter.entrypoint.api.model.response.ProductDto;
import com.github.prgrms.products.application.port.persistence.FindProductPort;
import com.github.prgrms.products.application.usecase.FindProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

@RequiredArgsConstructor
@Service
public class FindProductService implements FindProductUseCase {

  private final FindProductPort findProductPort;

  @Transactional(readOnly = true)
  @Override
  public ProductDto findProductById(Long productId) {
    checkNotNull(productId, "productId must be provided");
    return findProductPort.findProductById(productId);
  }

  @Transactional(readOnly = true)
  @Override
  public List<ProductDto> findAllProducts(Sort.Direction sort, String sortedField) {
    return findProductPort.findAllProducts(sort, sortedField);
  }

}
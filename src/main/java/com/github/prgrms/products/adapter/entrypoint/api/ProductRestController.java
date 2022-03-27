package com.github.prgrms.products.adapter.entrypoint.api;

import com.github.prgrms.errors.NotFoundException;
import com.github.prgrms.products.application.service.FindProductService;
import com.github.prgrms.products.adapter.entrypoint.api.model.response.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static com.github.prgrms.utils.ApiUtils.ApiResult;
import static com.github.prgrms.utils.ApiUtils.success;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/products")
public class ProductRestController {

  private final FindProductEndpointAdapter findProductEndpointAdapter;

  /**
   * 단일 상품조회
   * @param productId
   * @return ApiResult<ProductDto>
   */
  @GetMapping(path = "{id}")
  public ApiResult<ProductDto> findById(@PathVariable(name = "id") Long productId) {
    return success(findProductEndpointAdapter.findProductById(productId));
  }

  /**
   * 상품 목록조회
   * @return piResult<List<ProductDto>>
   */
  @GetMapping
  public ApiResult<List<ProductDto>> findAll() {
    return success(findProductEndpointAdapter.findAllProducts(Sort.Direction.DESC, "seq"));
  }

}
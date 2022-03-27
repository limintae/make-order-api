package com.github.prgrms.products.adapter.entrypoint.api.model.response;

import com.github.prgrms.products.adapter.persistence.model.Product;
import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDateTime;

import static org.springframework.beans.BeanUtils.copyProperties;

@Getter
public class ProductDto {

  private Long id;

  private String name;

  private String details;

  private int reviewCount;

  private LocalDateTime createAt;

  public ProductDto(Product source) {
    copyProperties(source, this);
  }

  @Builder
  public ProductDto(Long id, String name, String details, int reviewCount, LocalDateTime createAt) {
    this.id = id;
    this.name = name;
    this.details = details;
    this.reviewCount = reviewCount;
    this.createAt = createAt;
  }

  public static ProductDto of(Product source) {
    return ProductDto.builder()
            .id(source.getSeq())
            .name(source.getName())
            .details(source.getDetails())
            .reviewCount(source.getReviewCount())
            .createAt(source.getCreateAt())
            .build();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
        .append("id", id)
        .append("name", name)
        .append("details", details)
        .append("reviewCount", reviewCount)
        .append("createAt", createAt)
        .toString();
  }

}
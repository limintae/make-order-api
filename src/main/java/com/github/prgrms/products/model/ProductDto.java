package com.github.prgrms.products.model;

import com.github.prgrms.products.entity.Product;
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
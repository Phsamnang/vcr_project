package com.vcr.vcr_project.payload.product;

import lombok.Builder;

import java.math.BigDecimal;
@Builder
public record ProductResponse(Long productId, String productName,String categoryName,double stockQty,BigDecimal rielPrice,BigDecimal usdPrice) {
}

package com.vcr.vcr_project.payload.sale;

import lombok.Builder;

import java.math.BigDecimal;
@Builder
public record SaleDetailResponse(String item, Integer QTY, BigDecimal price,BigDecimal amount,String status) {
}

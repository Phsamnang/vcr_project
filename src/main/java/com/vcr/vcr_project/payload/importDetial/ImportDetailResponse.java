package com.vcr.vcr_project.payload.importDetial;

import lombok.Builder;

import java.math.BigDecimal;
@Builder
public record ImportDetailResponse(String productName, double QTY, BigDecimal price,BigDecimal amount) {
}

package com.vcr.vcr_project.payload.sale;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;
@Builder
public record SaleResponse(String tableName, BigDecimal totalAmount, List<SaleDetailResponse> orders) {
}

package com.vcr.vcr_project.model.payload.product;

import java.math.BigDecimal;

public record ProductResponse(Long productId, String productName, BigDecimal UsdPrice,BigDecimal rielPrice) {
}

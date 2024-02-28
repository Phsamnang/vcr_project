package com.vcr.vcr_project.payload.stock;

import lombok.Builder;

@Builder
public record StockRequest(Long productId,double qty) {
}

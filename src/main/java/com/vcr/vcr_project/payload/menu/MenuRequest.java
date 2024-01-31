package com.vcr.vcr_project.payload.menu;

import lombok.Builder;

import java.math.BigDecimal;
@Builder
public record MenuRequest(Long categoryId, String name, BigDecimal price, String image) {
}

package com.vcr.vcr_project.payload.category;

import com.vcr.vcr_project.payload.product.ProductResponse;
import lombok.Builder;

import java.util.List;
@Builder
public record MainCategoryResponse(Long categoryId, String categoryName, List<ProductResponse> products) {
}

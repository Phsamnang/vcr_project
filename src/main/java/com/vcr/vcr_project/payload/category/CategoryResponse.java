package com.vcr.vcr_project.payload.category;

import lombok.Builder;

@Builder
public record CategoryResponse(Long categoryId,String categoryName ) {
}

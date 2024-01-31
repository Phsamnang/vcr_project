package com.vcr.vcr_project.payload.importDetial;

import java.math.BigDecimal;

public record ImportDetailRequest(Long productId, Long importId, double importQty, BigDecimal importPrice) {
}

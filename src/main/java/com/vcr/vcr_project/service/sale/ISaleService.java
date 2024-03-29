package com.vcr.vcr_project.service.sale;

import com.vcr.vcr_project.payload.sale.SaleDetailRequest;
import com.vcr.vcr_project.payload.sale.SaleRequest;
import com.vcr.vcr_project.payload.sale.SaleResponse;

public interface ISaleService {
    void createSale(SaleRequest request);

    void createOrder(SaleDetailRequest request);
    SaleResponse getSaleByTable(Long tableId);
}

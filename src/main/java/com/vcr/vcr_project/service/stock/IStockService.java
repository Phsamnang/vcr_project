package com.vcr.vcr_project.service.stock;

import com.vcr.vcr_project.payload.stock.StockRequest;

public interface IStockService {
    void addStock(StockRequest payload);
}

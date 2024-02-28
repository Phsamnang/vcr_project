package com.vcr.vcr_project.controller;

import com.vcr.vcr_project.payload.stock.StockRequest;
import com.vcr.vcr_project.service.stock.IStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class StockController extends VCRRestController {
    private final IStockService service;
    @PostMapping("stock")
    public ResponseEntity<?> addStock(@RequestBody StockRequest payload) {
        service.addStock(payload);
        return ok();
    }
}

package com.vcr.vcr_project.controller;

import com.vcr.vcr_project.model.sale.SaleRepository;
import com.vcr.vcr_project.payload.sale.SaleDetailRequest;
import com.vcr.vcr_project.payload.sale.SaleRequest;
import com.vcr.vcr_project.service.sale.ISaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class SaleController extends VCRRestController {
    private final ISaleService service;

    @PostMapping("/sale")
    public ResponseEntity<?> createSale(@RequestBody SaleRequest request) {
        service.createSale(request);
        return ok();
    }

    @PostMapping("/order")
    public ResponseEntity<?> createOrder(@RequestBody SaleDetailRequest request) {
        service.createOrder(request);
        return ok();
    }

    @GetMapping("/sale/table/{id}")
    public ResponseEntity<?> getSaleBYTable(@PathVariable("id") Long tableId) {
        return ok(service.getSaleByTable(tableId));
    }
}

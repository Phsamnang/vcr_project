package com.vcr.vcr_project.service.stock;

import com.google.api.gax.rpc.NotFoundException;
import com.vcr.vcr_project.common.api.StatusCode;
import com.vcr.vcr_project.exception.BusinessException;
import com.vcr.vcr_project.model.product.Product;
import com.vcr.vcr_project.model.product.ProductRepository;
import com.vcr.vcr_project.model.stock.StockRepository;
import com.vcr.vcr_project.payload.stock.StockRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockService implements IStockService{
    private final StockRepository stockRepository;
    private final ProductRepository productRepository;
    @Override
    public void addStock(StockRequest payload) {
        var p=productRepository.findById(payload.productId()).orElseThrow(
                ()->new BusinessException(StatusCode.PRODUCT_NOT_FOUND)
        );
        var stock=stockRepository.findByProduct(p);
        stock.setNumber(stock.getNumber()+payload.qty());
        stockRepository.save(stock);
    }
}

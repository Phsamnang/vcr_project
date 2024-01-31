package com.vcr.vcr_project.service.ImportProduct;

import com.google.api.gax.rpc.NotFoundException;
import com.vcr.vcr_project.exception.EntityNotFoundException;
import com.vcr.vcr_project.model.Import.ImportDetail;
import com.vcr.vcr_project.model.Import.ImportDetailRepository;
import com.vcr.vcr_project.model.Import.ImportProduct;
import com.vcr.vcr_project.model.Import.ImportProductRepository;
import com.vcr.vcr_project.model.product.Product;
import com.vcr.vcr_project.model.product.ProductRepository;

import com.vcr.vcr_project.model.stock.StockRepository;
import com.vcr.vcr_project.payload.importDetial.ImportDetailMainResponse;
import com.vcr.vcr_project.payload.importDetial.ImportDetailRequest;
import com.vcr.vcr_project.payload.importDetial.ImportDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ImportProductService implements IImportProductService {
    private final ImportProductRepository importProductRepository;
    private final ImportDetailRepository importDetailRepository;
    private final ProductRepository productRepository;
    private final StockRepository stockRepository;

    @Override
    public void createImportProduct() {
        importProductRepository.save(new ImportProduct());
    }

    @Override
    public void createImportDetail(ImportDetailRequest payload) {
        var product = productRepository.findById(payload.productId()).orElseThrow(() -> new EntityNotFoundException(Product.class, "Product not found!"));
        var importProduct = importProductRepository.findById(payload.importId()).orElseThrow(() -> new EntityNotFoundException(ImportProduct.class, "Import not found"));
        var importDeatail = importDetailRepository.findByProductAndImportProduct(product, importProduct);
        var amount = payload.importPrice().multiply(BigDecimal.valueOf(payload.importQty()));
        var addTotoTal = importProduct.getImportTotal().add(amount);
        var stock=stockRepository.findByProduct(product);
        if (importDeatail.isPresent()) {
            var newQty = importDeatail.get().getImportQty() + payload.importQty();
            importDeatail.get().setImportQty(newQty);
            importDeatail.get().setAmount(importDeatail.get().getImportPrice().multiply(BigDecimal.valueOf(importDeatail.get().getImportQty())));
            importProduct.setImportTotal(addTotoTal);
            importProduct.setImportUsdTotal(importProduct.getImportTotal().divide(BigDecimal.valueOf(4000)));
            importDetailRepository.save(importDeatail.get());

        } else {
            importDetailRepository.save(ImportDetail.builder()
                    .product(product)
                    .importProduct(importProduct)
                    .importPrice(payload.importPrice())
                    .importQty(payload.importQty())
                    .amount(amount).build()
            );

            //System.err.println("total import "+ addTotoTal);
            importProduct.setImportTotal(addTotoTal);
            importProduct.setImportUsdTotal(importProduct.getImportTotal().divide(BigDecimal.valueOf(4000)));

        }
        stock.setNumber(stock.getNumber()+ payload.importQty());
        stockRepository.save(stock);
        importProductRepository.save(importProduct);
    }

    @Override
    public ImportDetailMainResponse getImportDetailById(Long id) {
        var importProduct = importProductRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(ImportProduct.class, "Import ID not found"));
        List<ImportDetailResponse> importDetailResponses = importProduct.getImportDetails().stream().map(i -> ImportDetailResponse.builder().productName(i.getProduct().getName())
                .price(i.getImportPrice())
                .QTY(i.getImportQty())
                .amount(i.getAmount()).build()).collect(Collectors.toList());
        return ImportDetailMainResponse.builder()
                .importId(importProduct.getId()).usdTotal(importProduct.getImportUsdTotal()).importTotal(importProduct.getImportTotal()).importDetails(importDetailResponses).build();
    }
}

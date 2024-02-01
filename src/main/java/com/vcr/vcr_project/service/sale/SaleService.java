package com.vcr.vcr_project.service.sale;

import com.vcr.vcr_project.exception.EntityNotFoundException;
import com.vcr.vcr_project.model.menu.Menu;
import com.vcr.vcr_project.model.menu.MenuRepository;
import com.vcr.vcr_project.model.sale.Sale;
import com.vcr.vcr_project.model.sale.SaleDetail;
import com.vcr.vcr_project.model.sale.SaleDetailRepository;
import com.vcr.vcr_project.model.sale.SaleRepository;
import com.vcr.vcr_project.model.stock.StockRepository;
import com.vcr.vcr_project.model.table.TableSale;
import com.vcr.vcr_project.model.table.TableSaleRepository;
import com.vcr.vcr_project.payload.sale.SaleDetailRequest;
import com.vcr.vcr_project.payload.sale.SaleRequest;
import com.vcr.vcr_project.utils.TableStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class SaleService implements ISaleService {
    private final SaleRepository saleRepository;
    private final TableSaleRepository tableSaleRepository;
    private final MenuRepository menuRepository;
    private final SaleDetailRepository saleDetailRepository;
    private final StockRepository stockRepository;

    @Override
    public void createSale(SaleRequest request) {
        var table = tableSaleRepository.findById(request.tableId()).orElseThrow(() -> new EntityNotFoundException(TableSale.class, "Table not found"));
        if (table.getStatus().equals(TableStatus.UNAVAILABLE.toString())) {
            throw new IllegalArgumentException("This table is using");
        }
        saleRepository.save(
                Sale.builder().tableSale(table).build()
        );
        table.setStatus(TableStatus.UNAVAILABLE.toString());
        tableSaleRepository.save(table);
    }

    @Override
    public void createOrder(SaleDetailRequest request) {
        var menu = menuRepository.findById(request.menuId()).orElseThrow(() -> new EntityNotFoundException(Menu.class, "Menu not found"));
        var sale = saleRepository.findById(request.saleId()).orElseThrow(() -> new EntityNotFoundException(Sale.class, "Sale not found"));
        saleDetailRepository.save(SaleDetail.
                builder().saleQty((int) request.qty())
                .salePrice(menu.getPrice()).saleAmount(menu.getPrice().multiply(BigDecimal.valueOf(request.qty())))
                .menu(menu).sale(sale).build());
        menu.getMenuDetails().stream().forEach(p -> {
            var stock = stockRepository.findByProduct(p.getProduct());
            stock.setNumber(stock.getNumber() - (p.getTotalUse() * request.qty()));
            stockRepository.save(stock);
        });

    }
}

package com.vcr.vcr_project.model.stock;

import com.vcr.vcr_project.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock,Long> {
    Stock findByProduct(Product product);
}

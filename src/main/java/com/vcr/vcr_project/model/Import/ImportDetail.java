package com.vcr.vcr_project.model.Import;

import com.vcr.vcr_project.model.product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "import_detail")
public class ImportDetail {
    @EmbeddedId
    private ImportDetailId id = new ImportDetailId();
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @MapsId("productId")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "import_id", referencedColumnName = "id")
    @MapsId("importId")
    private ImportProduct importProduct;
    @Column(name = "import_qty", nullable = false)
    private double importQty;
    @Column(name = "import_price", nullable = false)
    private BigDecimal importPrice;
    @Column(name = "amount")
    private BigDecimal amount;

    @Builder
    public ImportDetail(Product product, ImportProduct importProduct, double importQty, BigDecimal importPrice, BigDecimal amount) {
        this.product = product;
        this.importProduct = importProduct;
        this.importQty = importQty;
        this.importPrice = importPrice;
        this.amount = amount;
    }
}

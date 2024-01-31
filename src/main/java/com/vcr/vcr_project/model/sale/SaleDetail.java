package com.vcr.vcr_project.model.sale;

import com.vcr.vcr_project.model.product.Product;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "sale_detail")
public class SaleDetail {
    @EmbeddedId
    private SaleDetailId id =new SaleDetailId();
    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    @MapsId("productId")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "sale_id",referencedColumnName = "id")
    @MapsId("saleId")
    private Sale sale;
    @Column(name = "sale_qty")
    private Integer saleQty;
    @Column(name = "sale_price")
    private BigDecimal salePrice;
    @Column(name = "sale_amount")
    private BigDecimal saleAmount;
}

package com.vcr.vcr_project.model.sale;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbSale")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDateTime saleDate;

    private BigDecimal saleTotal;
    @OneToMany(mappedBy = "sale",fetch = FetchType.EAGER)
    private List<SaleDetail> saleDetails=new ArrayList<>();

}

package com.vcr.vcr_project.model.sale;

import com.vcr.vcr_project.enums.SaleStatus;
import com.vcr.vcr_project.model.table.TableSale;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbSale")
@Getter
@Setter
@NoArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDateTime saleDate;
    private BigDecimal saleTotal= BigDecimal.valueOf(0);
    private BigDecimal receiveMoney=BigDecimal.valueOf(0);
    private String status= SaleStatus.UNPAID.toString();
    @ManyToOne
    @JoinColumn(name = "table_id", referencedColumnName = "id")
    private TableSale tableSale;

    @OneToMany(mappedBy = "sale", fetch = FetchType.EAGER)
    private List<SaleDetail> saleDetails = new ArrayList<>();

    @Builder
    public Sale(TableSale tableSale) {
        this.tableSale = tableSale;
    }
}

package com.vcr.vcr_project.model.sale;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
public class SaleDetailId implements Serializable {
    @Column(nullable = false, insertable = false)
    private Long saleId;
    @Column(nullable = false, insertable = false)
    private Long menuId;
}

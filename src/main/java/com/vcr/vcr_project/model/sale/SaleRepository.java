package com.vcr.vcr_project.model.sale;

import com.vcr.vcr_project.model.table.TableSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale,Long> {
    Sale findByTableSaleAndStatus(TableSale tableSale,String status);
}

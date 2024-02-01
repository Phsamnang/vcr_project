package com.vcr.vcr_project.model.table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableSaleRepository extends JpaRepository<TableSale,Long> {
    TableSale findByName(String name);
}

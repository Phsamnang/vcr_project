package com.vcr.vcr_project.service.table;

import com.vcr.vcr_project.payload.table.TableRequest;

import javax.swing.text.TabExpander;

public interface ITableSaleService {
    void createTable(TableRequest request) throws Throwable;
}

package com.vcr.vcr_project.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private Integer id;
    private Integer product_id;
    private Integer qty;
}

package com.vcr.vcr_project.model.table;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_table_sale")
@Getter
@Setter
@NoArgsConstructor
public class TableSale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String name;
    private Boolean status=true;

}

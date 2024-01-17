package com.vcr.vcr_project.model.product;

import com.vcr.vcr_project.model.category.Category;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "product_name",nullable = false)
  private String name;
  private String image;
  @Column(name = "usd_price",nullable = false)
  private BigDecimal price;
  @Column(name = "riel_price",nullable = false)
  private BigDecimal rielPrice;
  @ManyToOne
  @JoinColumn(name = "category_id",referencedColumnName = "id")
  private Category category;
}

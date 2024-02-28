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
  @Column(name = "usd_price",columnDefinition = "decimal(8,2)")

  private BigDecimal price;
  @Column(name = "riel_price",columnDefinition = "decimal(8,2)")
  private BigDecimal rielPrice;
  private Boolean isAvailable=true;
  @ManyToOne
  @JoinColumn(name = "category_id",referencedColumnName = "id")
  private Category category;
@Builder

  public Product(String name, String image, BigDecimal price, BigDecimal rielPrice, Boolean isAvailable, Category category) {
    this.name = name;
    this.image = image;
    this.price = price;
    this.rielPrice = rielPrice;
    this.isAvailable = isAvailable;
    this.category = category;
  }
}

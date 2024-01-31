package com.vcr.vcr_project.model.menu;

import com.vcr.vcr_project.model.category.Category;
import jakarta.persistence.*;
import lombok.Builder;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
    private String name;
    private BigDecimal price;
    private BigDecimal usd;
    private String image;

    @Builder

    public Menu(Category category, String name, BigDecimal price, BigDecimal usd, String image) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.usd = usd;
        this.image = image;
    }
}

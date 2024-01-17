package com.vcr.vcr_project.model.category;

import com.vcr.vcr_project.model.product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "category_name",nullable = false)
    private String name;
    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<Product> products=new ArrayList<>();
    @Builder
    public Category(String name) {
        this.name = name;
    }
}

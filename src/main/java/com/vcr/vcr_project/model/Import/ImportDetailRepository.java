package com.vcr.vcr_project.model.Import;

import com.vcr.vcr_project.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImportDetailRepository extends JpaRepository<ImportDetail,Long> {
    Optional<ImportDetail>findByProductAndImportProduct(Product product,ImportProduct importProduct);
}

package com.vcr.vcr_project.model.Import;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportProductRepository extends JpaRepository<ImportProduct,Long> {
}

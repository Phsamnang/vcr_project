package com.vcr.vcr_project.model.Import;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ImportProductRepository extends JpaRepository<ImportProduct, Long> {
   ImportProduct findByImportDate(LocalDate date);
}

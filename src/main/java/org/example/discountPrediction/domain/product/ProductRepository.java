package org.example.discountPrediction.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p ORDER BY p.id DESC")
    List<Product> findAllDesc();
    List<Product> findByBrand(String brand);
    List<Product> findByCategory(String category);
    Optional<Product> findByProductName(String productName);
}

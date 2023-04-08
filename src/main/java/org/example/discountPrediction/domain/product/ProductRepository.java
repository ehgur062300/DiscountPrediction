package org.example.discountPrediction.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.productName LIKE %:keyword% OR p.brand LIKE %:keyword%")
    List<Product> search(@Param("keyword") String keyword);

    @Query("select p from Product p ORDER BY p.rank")
    List<Product> findAllDesc();

    List<Product> findByBrand(String brand);
    List<Product> findByCategory(String category);
    Optional<Product> findByProductName(String productName);
}

package org.example.discountPrediction.web.dto;

import lombok.Builder;
import lombok.Getter;
import org.example.discountPrediction.domain.product.Product;

@Getter
public class ProductResponseDto {
    private Long id;
    private String brand;
    private String category;
    private String productName;

    @Builder
    public ProductResponseDto(Product entity){
        this.id = entity.getId();
        this.brand = entity.getBrand();
        this.category = entity.getCategory();
        this.productName = entity.getProductName();
    }
}

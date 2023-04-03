package org.example.discountPrediction.web.dto;

import lombok.Builder;
import org.example.discountPrediction.domain.price.Price;
import org.example.discountPrediction.domain.product.Product;

import java.time.LocalDateTime;
import java.util.List;

public class ProductListResponseDto {
    private String brand;
    private String category;
    private List<Price> prices;
    private LocalDateTime modifiedDate;

    @Builder
    public ProductListResponseDto(Product entity){
        this.brand = entity.getBrand();
        this.category = entity.getCategory();
        this.prices = entity.getPrices();
        this.modifiedDate = entity.getModifiedDate();
    }

}

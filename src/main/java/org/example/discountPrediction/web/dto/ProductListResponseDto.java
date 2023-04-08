package org.example.discountPrediction.web.dto;

import lombok.Builder;
import org.example.discountPrediction.domain.product.Product;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ProductListResponseDto implements Serializable {

    private Long id;
    private String img;
    private int productId;
    private String productName;
    private String productUrl;
    private String brand;
    private String brandUrl;
    private int rank;
    private String category;
    private int realPrice;
    private LocalDateTime modifiedDate;

    @Builder
    public ProductListResponseDto(Product entity) {
        this.id = entity.getId();
        this.productId = entity.getProductId();
        this.img = entity.getImg();
        this.productName = entity.getProductName();
        this.productUrl = entity.getProductUrl();
        this.brand = entity.getBrand();
        this.brandUrl = entity.getBrandUrl();
        this.rank = entity.getRank();
        this.category = entity.getCategory();
        this.realPrice = entity.getRealPrice();
        this.modifiedDate = entity.getModifiedDate();
    }
}

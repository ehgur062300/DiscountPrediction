package org.example.discountPrediction.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.discountPrediction.domain.product.Product;

@Getter
@NoArgsConstructor
public class ProductSaveRequestDto {

    private int productId;
    private String img;
    private String productName;
    private String productUrl;
    private String brand;
    private String brandUrl;
    private int rank;
    private String category;
    private int realPrice;

    @Builder
    public ProductSaveRequestDto(int productId, int rank, String productName, String productUrl,
                   String img, String brand, String brandUrl, String category, int realPrice) {
        this.productId = productId;
        this.rank = rank;
        this.productName = productName;
        this.productUrl = productUrl;
        this.img = img;
        this.brand = brand;
        this.brandUrl = brandUrl;
        this.category = category;
        this.realPrice = realPrice;
    }

    public Product toEntity(){
        return Product.builder()
                .productId(productId)
                .rank(rank)
                .productName(productName)
                .productUrl(productUrl)
                .img(img)
                .brand(brand)
                .brandUrl(brandUrl)
                .category(category)
                .realPrice(realPrice)
                .build();
    }
}

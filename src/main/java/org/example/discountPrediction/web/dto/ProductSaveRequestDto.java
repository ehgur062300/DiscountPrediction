package org.example.discountPrediction.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.discountPrediction.domain.price.Price;
import org.example.discountPrediction.domain.product.Product;
import org.example.discountPrediction.service.product.ProductService;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class ProductSaveRequestDto {

    private int itemId;
    private String img;
    private String productName;
    private String productUrl;
    private String brand;
    private String brandUrl;
    private int rank;
    private String category;
    private int realPrice;

    @Builder
    public ProductSaveRequestDto(int item_id, int rank, String productName, String productUrl,
                   String img, String brand, String brandUrl, String category, int realPrice) {
        this.itemId = item_id;
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
                .itemId(itemId)
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

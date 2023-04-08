package org.example.discountPrediction.domain.product;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.discountPrediction.domain.BaseTimeEntity;
import org.example.discountPrediction.domain.price.Price;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Product extends BaseTimeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="product_id")
    private int productId;
    private String img;
    private String productName;
    @Column(name="product_Url")
    private String productUrl;
    private String brand;
    @Column(name="brand_Url")
    private String brandUrl;
    @Column(columnDefinition = "SMALLINT")
    private int rank;
    private String category;
    private int realPrice;
    private LocalDateTime modifiedDate;

    @OneToMany(mappedBy = "product")
    List<Price> prices = new ArrayList<>();

    @Builder
    public Product(int productId, int rank, String productName, String productUrl,
                   String img, String brand, String brandUrl, LocalDateTime modifiedDate,
                   String category, int realPrice, List<Price> prices) {
        this.productId = productId;
        this.rank = rank;
        this.productName = productName;
        this.productUrl = productUrl;
        this.img = img;
        this.brand = brand;
        this.brandUrl = brandUrl;
        this.modifiedDate = modifiedDate;
        this.category = category;
        this.realPrice = realPrice;
        this.prices = prices;
    }
}

package org.example.discountPrediction.domain.product;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.discountPrediction.domain.BaseTimeEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Product extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="item_id")
    private int itemId;

    @Column(columnDefinition = "SMALLINT")
    private int rank;

    private String productName;

    private String productUrl;

    private String img;

    private String brand;

    private String brandUrl;

    private LocalDateTime modifiedDate;

    private String category;

    private int realPrice;

    @Builder
    public Product(int item_id, int rank, String productName, String productUrl,
                   String img, String brand, String brandUrl, LocalDateTime modifiedDate,
                   String category, int realPrice) {
        this.itemId = item_id;
        this.rank = rank;
        this.productName = productName;
        this.productUrl = productUrl;
        this.img = img;
        this.brand = brand;
        this.brandUrl = brandUrl;
        this.modifiedDate = modifiedDate;
        this.category = category;
        this.realPrice = realPrice;
    }
}

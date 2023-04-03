package org.example.discountPrediction.domain.price;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.discountPrediction.domain.product.Product;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", referencedColumnName = "item_id",
            foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private Product product;

    private int rank;

    private int price;

    private int delPrice;

    private int coupon;

    private int rating;

    private int ratingCount;

    @Builder
    public Price(Product product, int rank, int delPrice, int coupon, int price, int rating, int ratingCount){
        this.product = product;
        this.rank = rank;
        this.price = price;
        this.delPrice = delPrice;
        this.coupon = coupon;
        this.rating = rating;
        this.ratingCount = ratingCount;
    }

}

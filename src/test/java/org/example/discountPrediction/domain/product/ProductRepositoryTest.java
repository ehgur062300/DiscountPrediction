package org.example.discountPrediction.domain.product;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @AfterEach
    public void cleanUp(){
        productRepository.deleteAll();
    }

    @Test
    public void 상품_정보_불러오기(){
        //given
        int itemId = 19991223;
        int rank = 1;

        productRepository.save(Product.builder()
                .item_id(itemId)
                .rank(rank)
                .realPrice(30000)
                .productName("test")
                .productUrl("http://test")
                .brand("test_brand")
                .brandUrl("http://test_brand")
                .category("001")
                .img("ads.jpg")
                .build());

        //when
        List<Product> productsList = productRepository.findAll();

        //then
        Product product = productsList.get(0);
        assertThat(product.getItemId()).isEqualTo(itemId);
        assertThat(product.getRank()).isEqualTo(rank);
    }

}
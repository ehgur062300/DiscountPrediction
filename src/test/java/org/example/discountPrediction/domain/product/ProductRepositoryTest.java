package org.example.discountPrediction.domain.product;

import org.example.discountPrediction.domain.price.Price;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
                .itemId(itemId)
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

    @Test
    public void 브랜드_정보_불러오기(){
        //given
        String brand = "brand";

        Product product1 = productRepository.save(Product.builder()
                .itemId(1)
                .brand("brand")
                .realPrice(1000)
                .build());

        Product product2 = productRepository.save(Product.builder()
                .itemId(2)
                .brand("Nobrand")
                .realPrice(1000)
                .build());

        Product product3 = productRepository.save(Product.builder()
                .itemId(3)
                .brand("brand")
                .realPrice(1000)
                .build());

        //when
        List<Product> productList = productRepository.findAll();

        //then
        System.out.println(productList.size());
        Product product = productList.get(2);
        assertThat(product.getBrand()).isEqualTo(brand);


    }

    @Test
    public void 카테고리_정보_불러오기(){
        //given
        String category = "000";

        productRepository.save(Product.builder()
                .itemId(1)
                .brand("brand")
                .category(category)
                .realPrice(1000)
                .build());

        //when
        List<Product> productList = productRepository.findAll();

        //then
        Product product = productList.get(0);
        assertThat(product.getCategory()).isEqualTo(category);
    }
    @Test
    public void 상품명_불러오기(){
        //given
        String name = "test_name";

        productRepository.save(Product.builder()
                .productName(name)
                .itemId(1)
                .brand("brand")
                .category("category")
                .realPrice(1000)
                .build());

        //when
        Optional<Product> product = productRepository.findByProductName(name);

        //then
        assertThat(product.get().getProductName()).isEqualTo(name);
    }
    @Test
    public void BasaeTimeEntity_등록(){
        //given
        LocalDateTime now = LocalDateTime.of(2019 , 6, 4, 0, 0, 0);
        productRepository.save(Product.builder()
                .itemId(1)
                .productName("test")
                .productUrl("test")
                .brand("test")
                .brandUrl("test")
                .rank(1)
                .category("001")
                .realPrice(1000)
                .build());
        //when
        List<Product> productsList = productRepository.findAll();

        //then
        Product product = productsList.get(0);

        System.out.println(">>>>>>>>>> createDate="+product.getCreatedDate()+
                ", modifiedDate="+product.getModifiedDate());

        assertThat(product.getCreatedDate()).isAfter(now);
        assertThat(product.getModifiedDate()).isAfter(now);
    }

}
package org.example.discountPrediction.service.product;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.ProcessIdUtil;
import org.example.discountPrediction.domain.product.Product;
import org.example.discountPrediction.domain.product.ProductRepository;
import org.example.discountPrediction.web.dto.ProductListResponseDto;
import org.example.discountPrediction.web.dto.ProductResponseDto;
import org.example.discountPrediction.web.dto.ProductSaveRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public Long save(ProductSaveRequestDto requestDto){
        return productRepository.save(requestDto.toEntity()).getId();
    }

    public ProductResponseDto findById(Long id){
        Product entity = productRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new ProductResponseDto(entity);
    }
    @Transactional
    public List<ProductListResponseDto> findByBrand(String brand){
        return productRepository.findByBrand(brand).stream()
                .map(ProductListResponseDto::new)
                .collect(Collectors.toList());
    }
    @Transactional
    public List<ProductListResponseDto> findByCategory(String category){
        return productRepository.findByCategory(category).stream()
                .map(ProductListResponseDto::new)
                .collect(Collectors.toList());
    }
    public ProductResponseDto findByPoductName(String productName){
        Product entity = productRepository.findByProductName(productName).orElseThrow(
                () -> new IllegalArgumentException("해당 상품명은 존재하지 않습니다. productName = " + productName));
        return new ProductResponseDto(entity);
    }
    public List<ProductListResponseDto> findAll(){
        return productRepository.findAll().stream()
                .map(ProductListResponseDto::new)
                .collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public List<ProductListResponseDto> findAllDesc(){
        return productRepository.findAllDesc().stream()
                .map(ProductListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProductListResponseDto> search(String keyword){
        return productRepository.search(keyword).stream()
                .map(ProductListResponseDto::new)
                .collect(Collectors.toList());
    }

}

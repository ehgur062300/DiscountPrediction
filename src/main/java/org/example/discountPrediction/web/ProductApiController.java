package org.example.discountPrediction.web;

import lombok.RequiredArgsConstructor;
import org.example.discountPrediction.service.product.ProductService;
import org.example.discountPrediction.web.dto.ProductSaveRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProductApiController {

    private final ProductService productService;

    @PostMapping("/api/v1/product")
    public Long save(@RequestBody ProductSaveRequestDto requestDto){
        return productService.save(requestDto);
    }

}

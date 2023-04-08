package org.example.discountPrediction.web;

import lombok.RequiredArgsConstructor;
import org.example.discountPrediction.service.product.ProductService;
import org.example.discountPrediction.web.dto.ProductSaveRequestDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ProductApiController {

    private final ProductService productService;


}

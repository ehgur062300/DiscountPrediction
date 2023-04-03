package org.example.discountPrediction.web;

import lombok.RequiredArgsConstructor;
import org.example.discountPrediction.service.product.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@RequiredArgsConstructor
@Controller
public class IndexController {
    private final ProductService productService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("products", productService.findAllDesc());
        return "index";
    }
    @GetMapping("/product/save")
    public String productsSave(){
        return "product_save";
    }

}

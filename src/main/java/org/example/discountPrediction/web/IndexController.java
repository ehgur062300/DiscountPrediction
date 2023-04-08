package org.example.discountPrediction.web;

import lombok.RequiredArgsConstructor;
import org.example.discountPrediction.service.product.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final ProductService productService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("products", productService.findAllDesc());
        return "index";
    }

    @GetMapping("/product/category/{category}")
    public String Category(@PathVariable String category, Model model) {
        model.addAttribute("category", productService.findByCategory(category));
        return "product_category";
    }

    @GetMapping("/product/search/{keyword}")
    public String productSearch(@PathVariable String keyword, Model model){
        model.addAttribute("keyword", productService.search(keyword));
        return "product_search";
    }

}

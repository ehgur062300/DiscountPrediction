package org.example.discountPrediction.web;

import lombok.RequiredArgsConstructor;
import org.example.discountPrediction.domain.config.auth.LoginUser;
import org.example.discountPrediction.domain.config.auth.dto.SessionUser;
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
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts", productService.findAllDesc());

        if(user != null){
            model.addAttribute("userName", user.getName());
        }
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

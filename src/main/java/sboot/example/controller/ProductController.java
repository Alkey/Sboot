package sboot.example.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sboot.example.dto.ProductResponseDto;
import sboot.example.service.ProductService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    @GetMapping("/most-commented")
    public List<ProductResponseDto> getMostCommentedProducts() {
        return service.getMostCommentedProducts();
    }
}

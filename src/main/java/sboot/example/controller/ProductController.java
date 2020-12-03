package sboot.example.controller;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sboot.example.dto.ProductResponseDto;
import sboot.example.mapper.ProductMapper;
import sboot.example.service.ProductService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;
    private final ProductMapper mapper;

    @GetMapping("/most-commented")
    public List<ProductResponseDto> getMostCommentedProducts() {
        return service.getMostCommentedProducts().stream()
                .map(mapper::getResponseDto)
                .collect(Collectors.toList());
    }
}

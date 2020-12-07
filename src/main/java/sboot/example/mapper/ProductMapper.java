package sboot.example.mapper;

import org.springframework.stereotype.Component;
import sboot.example.dto.ProductResponseDto;
import sboot.example.dto.ReviewDto;
import sboot.example.model.Product;

@Component
public class ProductMapper {

    public Product getProduct(ReviewDto dto) {
        Product product = new Product();
        product.setAmazonId(dto.getAmazonProductId());
        return product;
    }

    public ProductResponseDto getResponseDto(Product product) {
        ProductResponseDto dto = new ProductResponseDto();
        dto.setId(product.getId());
        dto.setAmazonId(product.getAmazonId());
        return dto;
    }
}

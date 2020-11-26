package sboot.example.mapper;

import org.springframework.stereotype.Component;
import sboot.example.dto.ReviewDto;
import sboot.example.model.Product;

@Component
public class ProductMapper {

    public Product getProduct(ReviewDto dto) {
        Product product = new Product();
        product.setAmazonId(dto.getAmazonProductId());
        return product;
    }
}

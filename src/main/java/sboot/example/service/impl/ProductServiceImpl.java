package sboot.example.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sboot.example.dao.ProductDao;
import sboot.example.dto.ProductResponseDto;
import sboot.example.mapper.ProductMapper;
import sboot.example.model.Product;
import sboot.example.service.ProductService;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDao dao;
    private final ProductMapper mapper;

    @Override
    public Product save(Product product) {
        return dao.save(product);
    }

    @Override
    public Product findByAmazonId(String id) {
        return dao.findByAmazonId(id);
    }

    @Override
    public List<Product> saveAll(List<Product> products) {
        return dao.saveAll(products);
    }

    @Override
    public List<ProductResponseDto> getMostCommentedProducts() {
        return dao.getMostCommentedProducts().stream()
                .map(mapper::getResponseDto)
                .collect(Collectors.toList());
    }
}

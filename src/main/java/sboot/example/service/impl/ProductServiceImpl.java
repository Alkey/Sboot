package sboot.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sboot.example.dao.ProductDao;
import sboot.example.model.Product;
import sboot.example.service.ProductService;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDao dao;

    @Override
    public Product save(Product product) {
        return dao.save(product);
    }

    @Override
    public Product findByAmazonId(String id) {
        return dao.findByAmazonId(id);
    }
}

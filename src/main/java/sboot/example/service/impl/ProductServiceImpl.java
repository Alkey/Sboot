package sboot.example.service.impl;

import java.util.List;
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

    @Override
    public List<Product> saveAll(List<Product> products) {
        return dao.saveAll(products);
    }

    @Override
    public List<Product> getMostCommentedProducts() {
        return dao.getMostCommentedProducts();
    }
}

package sboot.example.service;

import java.util.List;
import sboot.example.model.Product;

public interface ProductService {
    Product save(Product product);

    Product findByAmazonId(String id);

    List<Product> saveAll(List<Product> products);

    List<Product> getMostCommentedProducts();
}

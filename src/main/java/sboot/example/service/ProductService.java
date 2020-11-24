package sboot.example.service;

import sboot.example.model.Product;

public interface ProductService {
    Product save(Product product);

    Product findByAmazonId(String id);
}

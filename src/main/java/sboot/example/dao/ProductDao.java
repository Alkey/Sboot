package sboot.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sboot.example.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {
    Product findByAmazonId(String id);
}

package sboot.example.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sboot.example.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {
    Product findByAmazonId(String id);

    @Query(value = "SELECT products.id, products.amazon_id, count(*) as quantity "
            + "FROM comments join products on comments.product_id = products.id "
            + "group by products.amazon_id order by quantity DESC LIMIT 1000", nativeQuery = true)
    List<Product> getMostCommentedProducts();
}

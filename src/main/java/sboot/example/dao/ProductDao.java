package sboot.example.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sboot.example.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {
    Product findByAmazonId(String id);

    @Query(value = "select c.product from comments c group by c.product "
            + "order by count(c.product) desc limit 1000", nativeQuery = true)
    List<Product> getMostCommentedProducts();
}

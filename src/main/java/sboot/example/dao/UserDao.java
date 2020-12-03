package sboot.example.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sboot.example.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findByAmazonUserId(String id);

    @Query(value = "select User from Comment c "
            + "order by c.helpfulnessNumerator desc limit 1000", nativeQuery = true)
    List<User> getMostActiveUsers();
}

package sboot.example.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sboot.example.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findByAmazonId(String id);

    @Query(value = "SELECT users.id, amazon_id, users.name, users.password FROM comments "
            + "join USERS on comments.user_id=users.id "
            + "order by helpfulness_numerator DESC LIMIT 1000", nativeQuery = true)
    List<User> getMostActiveUsers();
}

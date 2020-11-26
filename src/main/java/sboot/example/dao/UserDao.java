package sboot.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sboot.example.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findByAmazonUserId(String id);
}

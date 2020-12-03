package sboot.example.service;

import java.util.List;
import org.springframework.stereotype.Service;
import sboot.example.model.User;

@Service
public interface UserService {
    User findById(Long id);

    User save(User user);

    User findByAmazonUserId(String id);

    List<User> saveAll(List<User> users);

    List<User> getMostActiveUsers();
}

package sboot.example.service;

import org.springframework.stereotype.Service;
import sboot.example.model.User;

@Service
public interface UserService {
    User findById(Long id);

    User save(User user);

    User findByAmazonUserId(String id);
}

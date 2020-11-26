package sboot.example.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sboot.example.dao.UserDao;
import sboot.example.model.User;
import sboot.example.service.UserService;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserDao dao;

    @Override
    public User findById(Long id) {
        return dao.getOne(id);
    }

    @Override
    public User save(User user) {
        return dao.save(user);
    }

    @Override
    public User findByAmazonUserId(String id) {
        return dao.findByAmazonUserId(id);
    }

    @Override
    public List<User> saveAll(List<User> users) {
        return dao.saveAll(users);
    }
}

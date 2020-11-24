package sboot.example.service.impl;

import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sboot.example.dao.UserDao;
import sboot.example.model.Role;
import sboot.example.model.User;
import sboot.example.service.UserService;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private static final String DEFAULT_PASSWORD = "1111";
    private static final Role DEFAULT_ROLE = Role.of("USER");
    private final UserDao dao;

    @Override
    public User findById(Long id) {
        return dao.getOne(id);
    }

    @Override
    public User save(User user) {
        user.setPassword(DEFAULT_PASSWORD);
        user.setRoles(Set.of(DEFAULT_ROLE));
        return dao.save(user);
    }

    @Override
    public User findByAmazonUserId(String id) {
        return dao.findByAmazonUserId(id);
    }
}

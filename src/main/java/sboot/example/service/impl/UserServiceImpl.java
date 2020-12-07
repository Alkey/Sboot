package sboot.example.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sboot.example.dao.UserDao;
import sboot.example.dto.UserResponseDto;
import sboot.example.mapper.UserMapper;
import sboot.example.model.User;
import sboot.example.service.UserService;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserDao dao;
    private final UserMapper userMapper;

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
        return dao.findByAmazonId(id);
    }

    @Override
    public List<User> saveAll(List<User> users) {
        return dao.saveAll(users);
    }

    @Override
    public List<UserResponseDto> getMostActiveUsers() {
        return dao.getMostActiveUsers()
                .stream()
                .map(userMapper::getResponseDto)
                .collect(Collectors.toList());
    }
}

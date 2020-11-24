package sboot.example.mapper;

import org.springframework.stereotype.Component;
import sboot.example.dto.ReviewDto;
import sboot.example.model.User;

@Component
public class UserMapper {

    public User getUser(ReviewDto dto) {
        User user = new User();
        user.setAmazonUserId(dto.getAmazonUserId());
        user.setName(dto.getAmazonProfileName());
        return user;
    }
}

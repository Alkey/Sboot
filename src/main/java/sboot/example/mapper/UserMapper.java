package sboot.example.mapper;

import org.springframework.stereotype.Component;
import sboot.example.dto.ReviewDto;
import sboot.example.dto.UserResponseDto;
import sboot.example.model.User;

@Component
public class UserMapper {

    public User getUser(ReviewDto dto) {
        User user = new User();
        user.setAmazonUserId(dto.getAmazonUserId());
        user.setName(dto.getAmazonProfileName());
        return user;
    }

    public UserResponseDto getResponseDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setAmazonUserId(user.getAmazonUserId());
        dto.setName(user.getName());
        return dto;
    }
}

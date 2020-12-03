package sboot.example.dto;

import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;
    private String amazonUserId;
    private String name;
}

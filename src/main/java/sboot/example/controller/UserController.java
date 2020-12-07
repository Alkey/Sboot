package sboot.example.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sboot.example.dto.UserResponseDto;
import sboot.example.service.UserService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    @GetMapping("/most-active")
    public List<UserResponseDto> getMostActiveUsers() {
        return service.getMostActiveUsers();
    }
}

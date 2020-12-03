package sboot.example.controller;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sboot.example.dto.WordResponseDto;
import sboot.example.mapper.WordMapper;
import sboot.example.service.WordService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/words")
public class WordController {
    private final WordService service;
    private final WordMapper mapper;

    @GetMapping
    public List<WordResponseDto> getMostUsedWords() {
        return service.getMostUsedWords().stream()
                .map(mapper::getResponseDto)
                .collect(Collectors.toList());
    }
}

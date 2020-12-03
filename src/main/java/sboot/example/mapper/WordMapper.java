package sboot.example.mapper;

import org.springframework.stereotype.Component;
import sboot.example.dto.WordResponseDto;
import sboot.example.model.Word;

@Component
public class WordMapper {
    public WordResponseDto getResponseDto(Word word) {
        WordResponseDto dto = new WordResponseDto();
        dto.setWord(word.getWord());
        dto.setQuantity(word.getQuantity());
        return dto;
    }
}

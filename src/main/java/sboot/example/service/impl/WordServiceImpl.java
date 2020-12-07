package sboot.example.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sboot.example.dao.WordDao;
import sboot.example.model.Word;
import sboot.example.service.WordService;

@RequiredArgsConstructor
@Service
public class WordServiceImpl implements WordService {
    private final WordDao dao;

    @Override
    public List<Word> getMostUsedWords() {
        return dao.findMostUsedWords();
    }

    @Override
    public Word save(Word word) {
        return dao.save(word);
    }

    @Override
    public List<Word> saveAll(List<Word> words) {
        return dao.saveAll(words);
    }
}

package sboot.example.service;

import java.util.List;
import sboot.example.model.Word;

public interface WordService {
    List<Word> getMostUsedWords();

    Word save(Word word);

    List<Word> saveAll(List<Word> words);
}


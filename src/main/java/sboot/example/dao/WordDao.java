package sboot.example.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sboot.example.model.Word;

@Repository
public interface WordDao extends JpaRepository<Word, Long> {
    @Query(value = "select * from words order by quantity desc limit 1000", nativeQuery = true)
    List<Word> findMostUsedWords();
}

package com.oceanebelle.generator.spanishcard.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface WordRepository extends JpaRepository<Word, String> {

    Stream<Word> findAllByType(Word.WordType type);
}

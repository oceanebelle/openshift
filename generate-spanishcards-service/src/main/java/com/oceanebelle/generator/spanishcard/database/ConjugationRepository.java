package com.oceanebelle.generator.spanishcard.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface ConjugationRepository extends JpaRepository<Conjugation, String> {

    Stream<Conjugation> findByIdAndType(String verb, Conjugation.ConjugationType type);

    @Query("SELECT DISTINCT c.id FROM Conjugation c")
    List<String> findDistinctById();
}

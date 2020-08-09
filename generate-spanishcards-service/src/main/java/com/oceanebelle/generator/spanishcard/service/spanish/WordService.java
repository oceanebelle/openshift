package com.oceanebelle.generator.spanishcard.service.spanish;

import com.oceanebelle.generator.spanishcard.database.WordRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WordService {
    private WordRepository wordRepository;

    public String singleEnFor(String word) {
        return wordRepository.findById(word).map(x -> x.getEnSingle()).orElse(word);
    }

    public String ingFor(String word) {
        return wordRepository.findById(word).map(x -> x.getIng()).orElse(word);
    }

    public String singleEsFor(String word) {
        return wordRepository.findById(word).map(x -> x.getEsSingle()).orElse(word);
    }

    public String pluralEnFor(String word) {
        return wordRepository.findById(word).map(x -> x.getEnPlural()).orElse(word);
    }

    public String pluralEsFor(String word) {
        return wordRepository.findById(word).map(x -> x.getEsPlural()).orElse(word);
    }

    public String pastEnFor(String word) {
        return wordRepository.findById(word).map(x -> x.getEnPast()).orElse(word);
    }
}

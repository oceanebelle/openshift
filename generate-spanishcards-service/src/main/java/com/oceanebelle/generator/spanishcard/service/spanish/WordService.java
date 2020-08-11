package com.oceanebelle.generator.spanishcard.service.spanish;

import com.oceanebelle.generator.spanishcard.database.Word;
import com.oceanebelle.generator.spanishcard.database.WordRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WordService {
    private WordRepository wordRepository;

    @Transactional
    public List<VerbInfo> getVerbs() {
        return wordRepository.findAllByType(Word.WordType.VERB)
                .map(x -> new VerbInfo(x.getId(), x.getEnSingle(), x.getSubject()))
                .collect(Collectors.toList());
    }

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

    @AllArgsConstructor
    @Getter
    public static class VerbInfo {
        private String esWord;
        private String enWord;
        private String subject;
    }
}

package com.oceanebelle.generator.spanishcard.service.spanish;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.util.comparator.Comparators;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

@Component
@AllArgsConstructor
@Log4j2
public class DefaultSpanishCardFactory implements SpanishCardFactory {
    private Collection<SpanishCardGenerator> cards;

    @PostConstruct
    private void configureCards() {
        log.info("Found {} card generators", cards.size());
    }

    public SpanishCardGenerator getGeneratorFor(String verb) {
        var sortByOrder = Comparator.comparingInt((SpanishCardGenerator x) -> x.getOrder());
        return cards.stream()
                .filter(c -> c.getVerbFilter().test(verb))
                .sorted(sortByOrder)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Unsupported verb " + verb));
    }

}

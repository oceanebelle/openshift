package com.oceanebelle.generator.spanishcard.service.spanish;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;
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
        return cards.stream()
                .filter(c -> c.getVerbFilter().test(verb))
                .sorted(Comparator.comparingInt(x -> x.getOrder()))
                .findFirst().orElseThrow(() -> new IllegalStateException("Unsupported verb " + verb));
    }

}

package com.oceanebelle.generator.spanishcard.service.spanish;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;

import static com.oceanebelle.generator.spanishcard.service.spanish.SpanishCardGenerator.Voice.*;

@Component
@AllArgsConstructor
public class SpanishCardGeneratorForIOARVerbs implements SpanishCardGenerator {

    private WordService wordService;

    @Override
    public SpanishVerbTypeFilter getVerbFilter() {
        return new EqualsSpanishVerbTypeFilter(Arrays.asList(
                "GUSTAR", "ENCANTAR", "PREOCUPAR", "COSTAR"));
    }

    @Override
    public Integer getOrder() {
        return SpanishCardGenerator.HIGH;
    }

    @Override
    public void printCard(String verb, String word, String subject, WriteCard card) throws IOException {
        card.write("I *" + wordService.pluralEnFor(word)  + "* " + subject,
                "*" + FIRST.io() + " " + presentAR(verb, THIRD_MALE) + "* " + wordService.singleEsFor(subject));

        card.write("I *" + wordService.pluralEnFor(word)  + "* " + wordService.pluralEnFor(subject),
                "*" + FIRST.io() + " " + presentAR(verb, THIRD_PL_MALE) + "* " + wordService.pluralEsFor(subject));
    }
}

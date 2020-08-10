package com.oceanebelle.generator.spanishcard.service.spanish;

import com.oceanebelle.generator.spanishcard.database.Conjugation;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Component
public class SpanishCardGeneratorForIrregular extends GenericVerbSpanishCardGenerator {

    private final ConjugationService conjugate;

    public SpanishCardGeneratorForIrregular(WordService words, ConjugationService conjugationService) {
        super(words);
        this.conjugate = conjugationService;
    }

    @Override
    public SpanishVerbTypeFilter getVerbFilter() {
        return new EqualsSpanishVerbTypeFilter(Arrays.asList(
                "DECIR", "DAR", "IR",
                "SER", "TENER", "HACER",
                "PODER"));
    }

    @Override
    public Integer getOrder() {
        return SpanishCardGenerator.HIGH;
    }

    protected String present(Voice voice, String verb) {
        return conjugate.conjugate(voice, verb, Conjugation.ConjugationType.IPRESENT, () -> verb);
    }
    protected String past(Voice voice, String verb) {
        return conjugate.conjugate(voice, verb, Conjugation.ConjugationType.IPRETERITE, () -> verb);
    }
    protected String pastImperfect(Voice voice, String verb) {
        return conjugate.conjugate(voice, verb, Conjugation.ConjugationType.IIMPERFECT, () -> verb);
    }

    @Override
    protected String conditional(Voice voice, String verb) {
        return conjugate.conjugate(voice, verb, Conjugation.ConjugationType.ICONDITIONAL,
                () -> super.conditional(voice, verb));
    }

    @Override
    protected String future(Voice voice, String verb) {
        return conjugate.conjugate(voice, verb, Conjugation.ConjugationType.IFUTURE,
                () -> super.future(voice, verb));
    }
}
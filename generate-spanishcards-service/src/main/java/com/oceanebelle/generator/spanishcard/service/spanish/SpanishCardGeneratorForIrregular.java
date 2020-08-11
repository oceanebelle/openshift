package com.oceanebelle.generator.spanishcard.service.spanish;

import com.oceanebelle.generator.spanishcard.database.Conjugation;
import org.springframework.stereotype.Component;


@Component
public class SpanishCardGeneratorForIrregular extends SpanishCardGeneratorForRegularVerbs {

    private final SpanishConjugationService conjugate;

    public SpanishCardGeneratorForIrregular(WordService words, SpanishConjugationService conjugationService) {
        super(words);
        this.conjugate = conjugationService;
    }

    @Override
    public SpanishVerbTypeFilter getVerbFilter() {
        // Automatically pickup irregular verbs
        return new EqualsSpanishVerbTypeFilter(conjugate.getIrregularVerbs());
    }

    @Override
    public Integer getOrder() {
        /**
         * Setting this to medium means this can be overridden by a more specific generator
         */
        return SpanishCardGenerator.MEDIUM;
    }

    protected String present(Voice voice, String verb) {
        return conjugate.conjugate(voice, verb, Conjugation.ConjugationType.IPRESENT, () -> presentVerb(voice, verb));
    }
    protected String past(Voice voice, String verb) {
        return conjugate.conjugate(voice, verb, Conjugation.ConjugationType.IPRETERITE, () -> pastVerb(voice, verb));
    }
    protected String pastImperfect(Voice voice, String verb) {
        return conjugate.conjugate(voice, verb, Conjugation.ConjugationType.IIMPERFECT, () -> pastImperfectVerb(voice, verb));
    }

    private String presentVerb(Voice voice, String verb) {
        if (verb.toUpperCase().endsWith("AR")) {
            return presentAR(verb, voice);
        }
        if (verb.toUpperCase().endsWith("ER")) {
            return presentER(verb, voice);
        }
        if (verb.toUpperCase().endsWith("IR")) {
            return presentIR(verb, voice);
        }
        throw new IllegalStateException("Unexpected verb " + verb);
    }

    private String pastVerb(Voice voice, String verb) {
        if (verb.toUpperCase().endsWith("AR")) {
            return pastAR(verb, voice);
        }
        if (verb.toUpperCase().endsWith("ER") || verb.toUpperCase().endsWith("IR")) {
            return pastERAndIR(verb, voice);
        }
        throw new IllegalStateException("Unexpected verb " + verb);
    }

    private String pastImperfectVerb(Voice voice, String verb) {
        if (verb.toUpperCase().endsWith("AR")) {
            return pastImperpectAR(verb, voice);
        }
        if (verb.toUpperCase().endsWith("ER") || verb.toUpperCase().endsWith("IR")) {
            return pastImperfectERAndIR(verb, voice);
        }
        throw new IllegalStateException("Unexpected verb " + verb);
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

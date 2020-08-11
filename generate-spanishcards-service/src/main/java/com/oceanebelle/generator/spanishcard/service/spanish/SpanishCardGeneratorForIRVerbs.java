package com.oceanebelle.generator.spanishcard.service.spanish;

import org.springframework.stereotype.Component;

@Component
public class SpanishCardGeneratorForIRVerbs extends SpanishCardGeneratorForRegularVerbs {

    public SpanishCardGeneratorForIRVerbs(WordService words) {
        super(words);
    }

    @Override
    public SpanishVerbTypeFilter getVerbFilter() {
        return new EndsWithSpanishVerbTypeFilter("IR");
    }

    protected String present(Voice voice, String verb) {
        return presentIR(verb, voice);
    }
    protected String past(Voice voice, String verb) {
        return pastERAndIR(verb, voice);
    }
    protected String pastImperfect(Voice voice, String verb) {
        return pastImperfectERAndIR(verb, voice);
    }
}

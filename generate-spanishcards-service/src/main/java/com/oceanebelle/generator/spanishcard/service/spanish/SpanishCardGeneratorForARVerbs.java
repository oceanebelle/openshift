package com.oceanebelle.generator.spanishcard.service.spanish;

import org.springframework.stereotype.Component;


@Component
public class SpanishCardGeneratorForARVerbs extends SpanishCardGeneratorForRegularVerbs {

    public SpanishCardGeneratorForARVerbs(WordService words) {
        super(words);
    }

    @Override
    public SpanishVerbTypeFilter getVerbFilter() {
        return new EndsWithSpanishVerbTypeFilter("AR");
    }



    protected String present(Voice voice, String verb) {
        return presentAR(verb, voice);
    }
    protected String past(Voice voice, String verb) {
        return pastAR(verb, voice);
    }
    protected String pastImperfect(Voice voice, String verb) {
        return pastImperpectAR(verb, voice);
    }
}

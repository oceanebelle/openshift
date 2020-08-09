package com.oceanebelle.generator.spanishcard.service.spanish;

import org.springframework.stereotype.Component;

@Component
public class SpanishCardGeneratorForERVerbs extends RegularVerbSpanishCardGenerator {

    public SpanishCardGeneratorForERVerbs(WordService words) {
        super(words);
    }

    @Override
    public SpanishVerbTypeFilter getVerbFilter() {
        return new EndsWithSpanishVerbTypeFilter("ER");
    }

    @Override
    public Integer getOrder() {
        return SpanishCardGenerator.LOW;
    }

    protected String present(Voice voice, String verb) {
        return presentER(verb, voice);
    }
    protected String past(Voice voice, String verb) {
        return pastERAndIR(verb, voice);
    }
    protected String pastImperfect(Voice voice, String verb) {
        return pastImperfectERAndIR(verb, voice);
    }
}

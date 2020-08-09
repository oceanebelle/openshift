package com.oceanebelle.generator.spanishcard.service.spanish;

import static com.oceanebelle.generator.spanishcard.service.spanish.SpanishCardGenerator.Voice.*;

public abstract class RegularVerbSpanishCardGenerator implements SpanishCardGenerator {

    protected WordService words;

    public RegularVerbSpanishCardGenerator(WordService words) {
        this.words = words;
    }

    @Override
    public SpanishVerbTypeFilter getVerbFilter() {
        return new EndsWithSpanishVerbTypeFilter("AR");
    }

    @Override
    public Integer getOrder() {
        return SpanishCardGenerator.LOW;
    }

    @Override
    public void printCard(String verb, String word, String subject, WriteCard card) {
        // Present
        card.write("I *" + words.pluralEnFor(word)  + "* " + subject,
                present(FIRST, verb, words.singleEsFor(subject)));

        card.write("You *" + words.pluralEnFor(word) + "* " + subject,
                present(SECOND, verb, words.singleEsFor(subject)));

        card.write("She *" + words.singleEnFor(word) + "* " + subject,
                present(THIRD_FEMALE, verb, words.singleEsFor(subject)));

        card.write("He *" + words.singleEnFor(word) + "* " + subject,
                present(THIRD_MALE, verb, words.singleEsFor(subject)));

        card.write("We *" + words.pluralEnFor(word) + "* " + subject,
                present(FIRST_PLURAL, verb, words.singleEsFor(subject)));

        card.write("You (all) *" + words.pluralEnFor(word) + "* " + subject,
                present(SECOND_PLURAL, verb, words.singleEsFor(subject)));

        card.write("They *" + words.pluralEnFor(word) + "* " + subject,
                present(THIRD_PL_MALE, verb, words.singleEsFor(subject)));

        // RegularPast
        card.write("I *" + words.pastEnFor(word)  + "* " + subject,
                past(FIRST, verb, words.singleEsFor(subject)));

        card.write("You *" + words.pastEnFor(word) + "* " + subject,
                past(SECOND, verb, words.singleEsFor(subject)));

        card.write("She *" + words.pastEnFor(word)+ "* " + subject,
                past(THIRD_FEMALE, verb, words.singleEsFor(subject)));

        card.write("He *" + words.pastEnFor(word) + "* " + subject,
                past(THIRD_MALE, verb, words.singleEsFor(subject)));

        card.write("We *" + words.pastEnFor(word) + "* " + subject,
                past(FIRST_PLURAL, verb, words.singleEsFor(subject)));

        card.write("You (all) *" + words.pastEnFor(word) + "* " + subject,
                past(SECOND_PLURAL, verb, words.singleEsFor(subject)));

        card.write("They *" + words.pastEnFor(word) + "* " + subject,
                past(THIRD_PL_MALE, verb, words.singleEsFor(subject)));

        // Past Imperfect tense
        card.write("I was *" + words.ingFor(word)  + "* " + subject,
                pastImperfect(FIRST, verb, words.singleEsFor(subject)));

        card.write("You were *" + words.ingFor(word) + "* " + subject,
                pastImperfect(SECOND, verb, words.singleEsFor(subject)));

        card.write("She was *" + words.ingFor(word)+ "* " + subject,
                pastImperfect(THIRD_FEMALE, verb, words.singleEsFor(subject)));

        card.write("He was *" + words.ingFor(word) + "* " + subject,
                pastImperfect(THIRD_MALE, verb, words.singleEsFor(subject)));

        card.write("We were *" + words.ingFor(word) + "* " + subject,
                pastImperfect(FIRST_PLURAL, verb, words.singleEsFor(subject)));

        card.write("You were (all) *" + words.ingFor(word) + "* " + subject,
                pastImperfect(SECOND_PLURAL, verb, words.singleEsFor(subject)));

        card.write("They were *" + words.ingFor(word) + "* " + subject,
                pastImperfect(THIRD_PL_MALE, verb, words.singleEsFor(subject)));
    }

    private String present(Voice voice, String verb, String predicate) {
        return voice.sub() + " *" + present(voice, verb) + "* " + predicate;
    }
    private String past(Voice voice, String verb, String predicate) {
        return voice.sub() + " *" + past(voice, verb) + "* " + predicate;
    }

    private String pastImperfect(Voice voice, String verb, String predicate) {
        return voice.sub() + " *" + pastImperfect(voice, verb) + "* " + predicate;
    }

    protected abstract String present(Voice voice, String verb);
    protected abstract String past(Voice voice, String verb);
    protected abstract String pastImperfect(Voice voice, String verb);
}

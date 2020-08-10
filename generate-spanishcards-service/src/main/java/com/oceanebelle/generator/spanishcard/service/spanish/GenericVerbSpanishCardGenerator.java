package com.oceanebelle.generator.spanishcard.service.spanish;

import static com.oceanebelle.generator.spanishcard.service.spanish.SpanishCardGenerator.Voice.*;

public abstract class GenericVerbSpanishCardGenerator implements SpanishCardGenerator {

    protected WordService words;

    public GenericVerbSpanishCardGenerator(WordService words) {
        this.words = words;
    }

    @Override
    public void printCard(String verb, String subject, WriteCard card) {

        writePresent(verb, subject, card);

        writePast(verb, subject, card);

        writePastImperfect(verb, subject, card);

        writeConditional(verb, subject, card);

        writeFuture(verb, subject, card);

    }

    protected void writePresent(String verb, String subject, WriteCard card) {
        card.write("Indicative Present", "el presente del indicativo");

        // Present
        card.write("I *" + words.pluralEnFor(verb)  + "* " + subject,
                present(FIRST, verb, words.singleEsFor(subject)));

        card.write("You *" + words.pluralEnFor(verb) + "* " + subject,
                present(SECOND, verb, words.singleEsFor(subject)));

        card.write("She *" + words.singleEnFor(verb) + "* " + subject,
                present(THIRD_FEMALE, verb, words.singleEsFor(subject)));

        card.write("He *" + words.singleEnFor(verb) + "* " + subject,
                present(THIRD_MALE, verb, words.singleEsFor(subject)));

        card.write("We *" + words.pluralEnFor(verb) + "* " + subject,
                present(FIRST_PLURAL, verb, words.singleEsFor(subject)));

        card.write("You (all) *" + words.pluralEnFor(verb) + "* " + subject,
                present(SECOND_PLURAL, verb, words.singleEsFor(subject)));

        card.write("They *" + words.pluralEnFor(verb) + "* " + subject,
                present(THIRD_PL_MALE, verb, words.singleEsFor(subject)));
    }

    protected void writePast(String verb, String subject, WriteCard card) {
        card.write("Indicative Past", "el preterito perfecto simple");

        // RegularPast
        card.write("I *" + words.pastEnFor(verb)  + "* " + subject,
                past(FIRST, verb, words.singleEsFor(subject)));

        card.write("You *" + words.pastEnFor(verb) + "* " + subject,
                past(SECOND, verb, words.singleEsFor(subject)));

        card.write("She *" + words.pastEnFor(verb)+ "* " + subject,
                past(THIRD_FEMALE, verb, words.singleEsFor(subject)));

        card.write("He *" + words.pastEnFor(verb) + "* " + subject,
                past(THIRD_MALE, verb, words.singleEsFor(subject)));

        card.write("We *" + words.pastEnFor(verb) + "* " + subject,
                past(FIRST_PLURAL, verb, words.singleEsFor(subject)));

        card.write("You (all) *" + words.pastEnFor(verb) + "* " + subject,
                past(SECOND_PLURAL, verb, words.singleEsFor(subject)));

        card.write("They *" + words.pastEnFor(verb) + "* " + subject,
                past(THIRD_PL_MALE, verb, words.singleEsFor(subject)));
    }

    private void writePastImperfect(String verb, String subject, WriteCard card) {
        card.write("Indicative Imperfect Tense", "el preterito imperfecto");

        // Past Imperfect tense
        card.write("I used to *" + words.pluralEnFor(verb)  + "* " + subject,
                pastImperfect(FIRST, verb, words.singleEsFor(subject)));

        card.write("You used to *" + words.pluralEnFor(verb) + "* " + subject,
                pastImperfect(SECOND, verb, words.singleEsFor(subject)));

        card.write("She used to *" + words.pluralEnFor(verb)+ "* " + subject,
                pastImperfect(THIRD_FEMALE, verb, words.singleEsFor(subject)));

        card.write("He used to *" + words.pluralEnFor(verb) + "* " + subject,
                pastImperfect(THIRD_MALE, verb, words.singleEsFor(subject)));

        card.write("We used to *" + words.pluralEnFor(verb) + "* " + subject,
                pastImperfect(FIRST_PLURAL, verb, words.singleEsFor(subject)));

        card.write("You (all) used to *" + words.pluralEnFor(verb) + "* " + subject,
                pastImperfect(SECOND_PLURAL, verb, words.singleEsFor(subject)));

        card.write("They used to *" + words.pluralEnFor(verb) + "* " + subject,
                pastImperfect(THIRD_PL_MALE, verb, words.singleEsFor(subject)));
    }

    private void writeConditional(String verb, String subject, WriteCard card) {
        card.write("Indicative Conditional Tense", "el pospreterito");

        // Past Imperfect tense
        card.write("I would *" + words.pluralEnFor(verb)  + "* " + subject,
                conditional(FIRST, verb, words.singleEsFor(subject)));

        card.write("You would *" + words.pluralEnFor(verb) + "* " + subject,
                conditional(SECOND, verb, words.singleEsFor(subject)));

        card.write("She would *" + words.pluralEnFor(verb)+ "* " + subject,
                conditional(THIRD_FEMALE, verb, words.singleEsFor(subject)));

        card.write("He would *" + words.pluralEnFor(verb) + "* " + subject,
                conditional(THIRD_MALE, verb, words.singleEsFor(subject)));

        card.write("We would *" + words.pluralEnFor(verb) + "* " + subject,
                conditional(FIRST_PLURAL, verb, words.singleEsFor(subject)));

        card.write("You (all) would *" + words.pluralEnFor(verb) + "* " + subject,
                conditional(SECOND_PLURAL, verb, words.singleEsFor(subject)));

        card.write("They would *" + words.pluralEnFor(verb) + "* " + subject,
                conditional(THIRD_PL_MALE, verb, words.singleEsFor(subject)));
    }

    private void writeFuture(String verb, String subject, WriteCard card) {
        card.write("Indicative Future Tense", "el futuro simple");

        // Past Imperfect tense
        card.write("I will *" + words.pluralEnFor(verb)  + "* " + subject,
                future(FIRST, verb, words.singleEsFor(subject)));

        card.write("You will *" + words.pluralEnFor(verb) + "* " + subject,
                future(SECOND, verb, words.singleEsFor(subject)));

        card.write("She will *" + words.pluralEnFor(verb)+ "* " + subject,
                future(THIRD_FEMALE, verb, words.singleEsFor(subject)));

        card.write("He will *" + words.pluralEnFor(verb) + "* " + subject,
                future(THIRD_MALE, verb, words.singleEsFor(subject)));

        card.write("We will *" + words.pluralEnFor(verb) + "* " + subject,
                future(FIRST_PLURAL, verb, words.singleEsFor(subject)));

        card.write("You (all) will *" + words.pluralEnFor(verb) + "* " + subject,
                future(SECOND_PLURAL, verb, words.singleEsFor(subject)));

        card.write("They will *" + words.pluralEnFor(verb) + "* " + subject,
                future(THIRD_PL_MALE, verb, words.singleEsFor(subject)));
    }


    private String present(Voice voice, String verb, String subject) {
        return voice.sub() + " *" + present(voice, verb) + "* " + subject;
    }
    private String past(Voice voice, String verb, String subject) {
        return voice.sub() + " *" + past(voice, verb) + "* " + subject;
    }
    private String pastImperfect(Voice voice, String verb, String subject) {
        return voice.sub() + " *" + pastImperfect(voice, verb) + "* " + subject;
    }

    private String conditional(Voice voice, String verb, String subject) {
        return voice.sub() + " *" + conditional(voice, verb) + "* " + subject;
    }

    private String future(Voice voice, String verb, String subject) {
        return voice.sub() + " *" + future(voice, verb) + "* " + subject;
    }

    protected abstract String present(Voice voice, String verb);
    protected abstract String past(Voice voice, String verb);
    protected abstract String pastImperfect(Voice voice, String verb);
    protected String conditional(Voice voice, String verb) {
        return conditionalAll(verb, voice);
    }
    protected String future(Voice voice, String verb) {
        return futureAll(verb, voice);
    }


}

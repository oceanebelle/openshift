package com.oceanebelle.generator.spanishcard.service.spanish;

import static com.oceanebelle.generator.spanishcard.service.spanish.SpanishCardGenerator.Voice.*;

public abstract class SpanishCardGeneratorForRegularVerbs implements SpanishCardGenerator {

    protected WordService words;

    public SpanishCardGeneratorForRegularVerbs(WordService words) {
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
                presentSentence(FIRST, verb, words.singleEsFor(subject)));

        card.write("You *" + words.pluralEnFor(verb) + "* " + subject,
                presentSentence(SECOND, verb, words.singleEsFor(subject)));

        card.write("She *" + words.singleEnFor(verb) + "* " + subject,
                presentSentence(THIRD_FEMALE, verb, words.singleEsFor(subject)));

        card.write("He *" + words.singleEnFor(verb) + "* " + subject,
                presentSentence(THIRD_MALE, verb, words.singleEsFor(subject)));

        card.write("We *" + words.pluralEnFor(verb) + "* " + subject,
                presentSentence(FIRST_PLURAL, verb, words.singleEsFor(subject)));

        card.write("You (all) *" + words.pluralEnFor(verb) + "* " + subject,
                presentSentence(SECOND_PLURAL, verb, words.singleEsFor(subject)));

        card.write("They *" + words.pluralEnFor(verb) + "* " + subject,
                presentSentence(THIRD_PL_MALE, verb, words.singleEsFor(subject)));
    }

    protected void writePast(String verb, String subject, WriteCard card) {
        card.write("Indicative Past", "el preterito perfecto simple");

        // RegularPast
        card.write("I *" + words.pastEnFor(verb)  + "* " + subject,
                pastSentence(FIRST, verb, words.singleEsFor(subject)));

        card.write("You *" + words.pastEnFor(verb) + "* " + subject,
                pastSentence(SECOND, verb, words.singleEsFor(subject)));

        card.write("She *" + words.pastEnFor(verb)+ "* " + subject,
                pastSentence(THIRD_FEMALE, verb, words.singleEsFor(subject)));

        card.write("He *" + words.pastEnFor(verb) + "* " + subject,
                pastSentence(THIRD_MALE, verb, words.singleEsFor(subject)));

        card.write("We *" + words.pastEnFor(verb) + "* " + subject,
                pastSentence(FIRST_PLURAL, verb, words.singleEsFor(subject)));

        card.write("You (all) *" + words.pastEnFor(verb) + "* " + subject,
                pastSentence(SECOND_PLURAL, verb, words.singleEsFor(subject)));

        card.write("They *" + words.pastEnFor(verb) + "* " + subject,
                pastSentence(THIRD_PL_MALE, verb, words.singleEsFor(subject)));
    }

    protected void writePastImperfect(String verb, String subject, WriteCard card) {
        card.write("Indicative Imperfect Tense", "el preterito imperfecto");

        // Past Imperfect tense
        card.write("I used to *" + words.pluralEnFor(verb)  + "* " + subject,
                pastImperfectSentence(FIRST, verb, words.singleEsFor(subject)));

        card.write("You used to *" + words.pluralEnFor(verb) + "* " + subject,
                pastImperfectSentence(SECOND, verb, words.singleEsFor(subject)));

        card.write("She used to *" + words.pluralEnFor(verb)+ "* " + subject,
                pastImperfectSentence(THIRD_FEMALE, verb, words.singleEsFor(subject)));

        card.write("He used to *" + words.pluralEnFor(verb) + "* " + subject,
                pastImperfectSentence(THIRD_MALE, verb, words.singleEsFor(subject)));

        card.write("We used to *" + words.pluralEnFor(verb) + "* " + subject,
                pastImperfectSentence(FIRST_PLURAL, verb, words.singleEsFor(subject)));

        card.write("You (all) used to *" + words.pluralEnFor(verb) + "* " + subject,
                pastImperfectSentence(SECOND_PLURAL, verb, words.singleEsFor(subject)));

        card.write("They used to *" + words.pluralEnFor(verb) + "* " + subject,
                pastImperfectSentence(THIRD_PL_MALE, verb, words.singleEsFor(subject)));
    }

    protected void writeConditional(String verb, String subject, WriteCard card) {
        card.write("Indicative Conditional Tense", "el pospreterito");

        // Past Imperfect tense
        card.write("I would *" + words.pluralEnFor(verb)  + "* " + subject,
                conditionalSentence(FIRST, verb, words.singleEsFor(subject)));

        card.write("You would *" + words.pluralEnFor(verb) + "* " + subject,
                conditionalSentence(SECOND, verb, words.singleEsFor(subject)));

        card.write("She would *" + words.pluralEnFor(verb)+ "* " + subject,
                conditionalSentence(THIRD_FEMALE, verb, words.singleEsFor(subject)));

        card.write("He would *" + words.pluralEnFor(verb) + "* " + subject,
                conditionalSentence(THIRD_MALE, verb, words.singleEsFor(subject)));

        card.write("We would *" + words.pluralEnFor(verb) + "* " + subject,
                conditionalSentence(FIRST_PLURAL, verb, words.singleEsFor(subject)));

        card.write("You (all) would *" + words.pluralEnFor(verb) + "* " + subject,
                conditionalSentence(SECOND_PLURAL, verb, words.singleEsFor(subject)));

        card.write("They would *" + words.pluralEnFor(verb) + "* " + subject,
                conditionalSentence(THIRD_PL_MALE, verb, words.singleEsFor(subject)));
    }

    protected void writeFuture(String verb, String subject, WriteCard card) {
        card.write("Indicative Future Tense", "el futuro simple");

        // Past Imperfect tense
        card.write("I will *" + words.pluralEnFor(verb)  + "* " + subject,
                futureSentence(FIRST, verb, words.singleEsFor(subject)));

        card.write("You will *" + words.pluralEnFor(verb) + "* " + subject,
                futureSentence(SECOND, verb, words.singleEsFor(subject)));

        card.write("She will *" + words.pluralEnFor(verb)+ "* " + subject,
                futureSentence(THIRD_FEMALE, verb, words.singleEsFor(subject)));

        card.write("He will *" + words.pluralEnFor(verb) + "* " + subject,
                futureSentence(THIRD_MALE, verb, words.singleEsFor(subject)));

        card.write("We will *" + words.pluralEnFor(verb) + "* " + subject,
                futureSentence(FIRST_PLURAL, verb, words.singleEsFor(subject)));

        card.write("You (all) will *" + words.pluralEnFor(verb) + "* " + subject,
                futureSentence(SECOND_PLURAL, verb, words.singleEsFor(subject)));

        card.write("They will *" + words.pluralEnFor(verb) + "* " + subject,
                futureSentence(THIRD_PL_MALE, verb, words.singleEsFor(subject)));
    }


    protected String presentSentence(Voice voice, String verb, String subject) {
        return voice.sub() + " *" + present(voice, verb) + "* " + subject;
    }
    protected String pastSentence(Voice voice, String verb, String subject) {
        return voice.sub() + " *" + past(voice, verb) + "* " + subject;
    }
    protected String pastImperfectSentence(Voice voice, String verb, String subject) {
        return voice.sub() + " *" + pastImperfect(voice, verb) + "* " + subject;
    }

    protected String conditionalSentence(Voice voice, String verb, String subject) {
        return voice.sub() + " *" + conditional(voice, verb) + "* " + subject;
    }
    protected String futureSentence(Voice voice, String verb, String subject) {
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

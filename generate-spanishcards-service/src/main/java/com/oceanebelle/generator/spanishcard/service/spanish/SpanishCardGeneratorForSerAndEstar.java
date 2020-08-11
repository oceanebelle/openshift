package com.oceanebelle.generator.spanishcard.service.spanish;

import org.springframework.stereotype.Component;

import java.util.Arrays;

import static com.oceanebelle.generator.spanishcard.service.spanish.SpanishCardGenerator.Voice.*;


@Component
public class SpanishCardGeneratorForSerAndEstar extends SpanishCardGeneratorForIrregular {

    public SpanishCardGeneratorForSerAndEstar(WordService words, ConjugationService conjugationService) {
        super(words, conjugationService);
    }

    /**
     * SER is for state that doesn't change - e.g. facts
     * ESTAR is for temporary or changing state - e.g. I am sleepy
     * @return
     */
    @Override
    public SpanishVerbTypeFilter getVerbFilter() {
        return new EqualsSpanishVerbTypeFilter(Arrays.asList(
                "SER", "ESTAR"));
    }

    @Override
    public Integer getOrder() {
        return SpanishCardGenerator.HIGH;
    }

    protected void writePresent(String verb, String subject, WriteCard card) {
        card.write("Indicative Present", "el presente del indicativo");

        // Present
        card.write("I *am* " + subject,
                presentSentence(FIRST, verb, words.singleEsFor(subject)));

        card.write("You *are* " + subject,
                presentSentence(SECOND, verb, words.singleEsFor(subject)));

        card.write("She *is* " + subject,
                presentSentence(THIRD_FEMALE, verb, words.singleEsFor(subject)));

        card.write("He *is* " + subject,
                presentSentence(THIRD_MALE, verb, words.singleEsFor(subject)));

        card.write("We *are* " + subject,
                presentSentence(FIRST_PLURAL, verb, words.singleEsFor(subject)));

        card.write("You (all) *are* " + subject,
                presentSentence(SECOND_PLURAL, verb, words.singleEsFor(subject)));

        card.write("They *are* " + subject,
                presentSentence(THIRD_PL_MALE, verb, words.singleEsFor(subject)));
    }

    protected void writePast(String verb, String subject, WriteCard card) {
        card.write("Indicative Past", "el preterito perfecto simple");

        // RegularPast
        card.write("I *was* " + subject,
                pastSentence(FIRST, verb, words.singleEsFor(subject)));

        card.write("You *were* " + subject,
                pastSentence(SECOND, verb, words.singleEsFor(subject)));

        card.write("She *was* " + subject,
                pastSentence(THIRD_FEMALE, verb, words.singleEsFor(subject)));

        card.write("He *was* " + subject,
                pastSentence(THIRD_MALE, verb, words.singleEsFor(subject)));

        card.write("We *were* " + subject,
                pastSentence(FIRST_PLURAL, verb, words.singleEsFor(subject)));

        card.write("You (all) *were* " + subject,
                pastSentence(SECOND_PLURAL, verb, words.singleEsFor(subject)));

        card.write("They *were* " + subject,
                pastSentence(THIRD_PL_MALE, verb, words.singleEsFor(subject)));
    }

    protected void writePastImperfect(String verb, String subject, WriteCard card) {
        card.write("Indicative Imperfect Tense", "el preterito imperfecto");

        // Past Imperfect tense
        card.write("I used to *be* " + subject,
                pastImperfectSentence(FIRST, verb, words.singleEsFor(subject)));

        card.write("You used to *be* " + subject,
                pastImperfectSentence(SECOND, verb, words.singleEsFor(subject)));

        card.write("She used to *be* " + subject,
                pastImperfectSentence(THIRD_FEMALE, verb, words.singleEsFor(subject)));

        card.write("He used to *be* " + subject,
                pastImperfectSentence(THIRD_MALE, verb, words.singleEsFor(subject)));

        card.write("We used to *be* " + subject,
                pastImperfectSentence(FIRST_PLURAL, verb, words.singleEsFor(subject)));

        card.write("You (all) used to *be* " + subject,
                pastImperfectSentence(SECOND_PLURAL, verb, words.singleEsFor(subject)));

        card.write("They used to *be* " + subject,
                pastImperfectSentence(THIRD_PL_MALE, verb, words.singleEsFor(subject)));
    }

    protected void writeConditional(String verb, String subject, WriteCard card) {
        card.write("Indicative Conditional Tense", "el pospreterito");

        // Past Imperfect tense
        card.write("I would *be* " + subject,
                conditionalSentence(FIRST, verb, words.singleEsFor(subject)));

        card.write("You would *be* " + subject,
                conditionalSentence(SECOND, verb, words.singleEsFor(subject)));

        card.write("She would *be* " + subject,
                conditionalSentence(THIRD_FEMALE, verb, words.singleEsFor(subject)));

        card.write("He would *be* " + subject,
                conditionalSentence(THIRD_MALE, verb, words.singleEsFor(subject)));

        card.write("We would *be* " + subject,
                conditionalSentence(FIRST_PLURAL, verb, words.singleEsFor(subject)));

        card.write("You (all) would *be* " + subject,
                conditionalSentence(SECOND_PLURAL, verb, words.singleEsFor(subject)));

        card.write("They would *be* " + subject,
                conditionalSentence(THIRD_PL_MALE, verb, words.singleEsFor(subject)));
    }

    protected void writeFuture(String verb, String subject, WriteCard card) {
        card.write("Indicative Future Tense", "el futuro simple");

        // Past Imperfect tense
        card.write("I will *be* " + subject,
                futureSentence(FIRST, verb, words.singleEsFor(subject)));

        card.write("You will *be* " + subject,
                futureSentence(SECOND, verb, words.singleEsFor(subject)));

        card.write("She will *be* " + subject,
                futureSentence(THIRD_FEMALE, verb, words.singleEsFor(subject)));

        card.write("He will *be* " + subject,
                futureSentence(THIRD_MALE, verb, words.singleEsFor(subject)));

        card.write("We will *be* " + subject,
                futureSentence(FIRST_PLURAL, verb, words.singleEsFor(subject)));

        card.write("You (all) will *be* " + subject,
                futureSentence(SECOND_PLURAL, verb, words.singleEsFor(subject)));

        card.write("They will *be* " + subject,
                futureSentence(THIRD_PL_MALE, verb, words.singleEsFor(subject)));
    }
}

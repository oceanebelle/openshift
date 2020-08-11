package com.oceanebelle.generator.spanishcard.service.spanish;

import java.io.IOException;

public interface SpanishCardGenerator {
    Integer HIGH = 1;
    Integer LOW = 10;

    SpanishVerbTypeFilter getVerbFilter();

    Integer getOrder();


    void printCard(String verb, String subject, WriteCard card) throws IOException;

    enum Voice {
        /**
         * yo
         */
        FIRST("yo", "me"),
        /**
         * tú
         */
        SECOND("tú", "te"),
        /**
         * él, ella, usted (formal)
         */
        THIRD_MALE("él", "le"),
        THIRD_FEMALE("ella", "le"),
        THIRD_FORMAL("usted", "le"),
        /**
         * Nosotros
         */
        FIRST_PLURAL("nosotros", "nos"),
        /**
         * vosotros
         */
        SECOND_PLURAL("vosotros", "os"),
        /**
         * Ellas, Ellos, Ustedes (formal)
         */
        THIRD_PL_MALE("éllos", "les"),
        THIRD_PL_FEMALE("ellas", "les"),
        THIRD_PL_FORMAL("ustedes", "les"),;
        private final String sub;
        private final String io;

        Voice(String sub, String io) {
            this.sub = sub;
            this.io = io;
        }

        /**
         * Personal Subject Pronoun
         */
        public String sub() {
            return sub;
        }

        /**
         * Indirect Object
         */
        public String io() {
            return io;
        }
    }

    default String presentAR(String verb, Voice voice) {
        switch(voice) {
            default:
            case FIRST:
                return verbRootWithSuffix(verb, "o");
            case SECOND:
                return verbRootWithSuffix(verb, "as");
            case THIRD_MALE:
            case THIRD_FEMALE:
            case THIRD_FORMAL:
                return verbRootWithSuffix(verb, "a");
            case FIRST_PLURAL:
                return verbRootWithSuffix(verb, "amos");
            case SECOND_PLURAL:
                return verbRootWithSuffix(verb, "áis");
            case THIRD_PL_FEMALE:
            case THIRD_PL_MALE:
            case THIRD_PL_FORMAL:
                return verbRootWithSuffix(verb, "an");
        }
    }

    default String pastAR(String verb, Voice voice) {
        switch(voice) {
            default:
            case FIRST:
                return verbRootWithSuffix(verb, "é");
            case SECOND:
                return verbRootWithSuffix(verb, "aste");
            case THIRD_MALE:
            case THIRD_FEMALE:
            case THIRD_FORMAL:
                return verbRootWithSuffix(verb, "ó");
            case FIRST_PLURAL:
                return verbRootWithSuffix(verb, "amos");
            case SECOND_PLURAL:
                return verbRootWithSuffix(verb, "asteis");
            case THIRD_PL_FEMALE:
            case THIRD_PL_MALE:
            case THIRD_PL_FORMAL:
                return verbRootWithSuffix(verb, "aron");
        }
    }

    default String pastERAndIR(String verb, Voice voice) {
        switch(voice) {
            default:
            case FIRST:
                return verbRootWithSuffix(verb, "í");
            case SECOND:
                return verbRootWithSuffix(verb, "iste");
            case THIRD_MALE:
            case THIRD_FEMALE:
            case THIRD_FORMAL:
                return verbRootWithSuffix(verb, "ió");
            case FIRST_PLURAL:
                return verbRootWithSuffix(verb, "imos");
            case SECOND_PLURAL:
                return verbRootWithSuffix(verb, "isteis");
            case THIRD_PL_FEMALE:
            case THIRD_PL_MALE:
            case THIRD_PL_FORMAL:
                return verbRootWithSuffix(verb, "ieron");
        }
    }

    /**
     * The Spanish imperfect tense (el pretérito
     * imperfecto
     *  o
     * copretérito
     *
     * ) is used to describe past habitual actions or to talk about what someone
     * was doing when they were interrupted by something else.
     */
    default String pastImperpectAR(String verb, Voice voice) {
        switch(voice) {
            default:
            case FIRST:
                return verbRootWithSuffix(verb, "aba");
            case SECOND:
                return verbRootWithSuffix(verb, "abas");
            case THIRD_MALE:
            case THIRD_FEMALE:
            case THIRD_FORMAL:
                return verbRootWithSuffix(verb, "aba");
            case FIRST_PLURAL:
                return verbRootWithSuffix(verb, "abais");
            case SECOND_PLURAL:
                return verbRootWithSuffix(verb, "asteis");
            case THIRD_PL_FEMALE:
            case THIRD_PL_MALE:
            case THIRD_PL_FORMAL:
                return verbRootWithSuffix(verb, "aban");
        }
    }

    default String pastImperfectERAndIR(String verb, Voice voice) {
        switch(voice) {
            default:
            case FIRST:
                return verbRootWithSuffix(verb, "ía");
            case SECOND:
                return verbRootWithSuffix(verb, "ías");
            case THIRD_MALE:
            case THIRD_FEMALE:
            case THIRD_FORMAL:
                return verbRootWithSuffix(verb, "ía");
            case FIRST_PLURAL:
                return verbRootWithSuffix(verb, "íamos");
            case SECOND_PLURAL:
                return verbRootWithSuffix(verb, "íais");
            case THIRD_PL_FEMALE:
            case THIRD_PL_MALE:
            case THIRD_PL_FORMAL:
                return verbRootWithSuffix(verb, "ían");
        }
    }

    default String presentER(String verb, Voice voice) {
        switch(voice) {
            default:
            case FIRST:
                return verbRootWithSuffix(verb, "o");
            case SECOND:
                return verbRootWithSuffix(verb, "es");
            case THIRD_MALE:
            case THIRD_FEMALE:
            case THIRD_FORMAL:
                return verbRootWithSuffix(verb, "e");
            case FIRST_PLURAL:
                return verbRootWithSuffix(verb, "emos");
            case SECOND_PLURAL:
                return verbRootWithSuffix(verb, "éis");
            case THIRD_PL_FEMALE:
            case THIRD_PL_MALE:
            case THIRD_PL_FORMAL:
                return verbRootWithSuffix(verb, "en");
        }
    }

    default String presentIR(String verb, Voice voice) {
        switch(voice) {
            default:
            case FIRST:
                return verbRootWithSuffix(verb, "o");
            case SECOND:
                return verbRootWithSuffix(verb, "es");
            case THIRD_MALE:
            case THIRD_FEMALE:
            case THIRD_FORMAL:
                return verbRootWithSuffix(verb, "e");
            case FIRST_PLURAL:
                return verbRootWithSuffix(verb, "imos");
            case SECOND_PLURAL:
                return verbRootWithSuffix(verb, "ís");
            case THIRD_PL_FEMALE:
            case THIRD_PL_MALE:
            case THIRD_PL_FORMAL:
                return verbRootWithSuffix(verb, "en");
        }
    }

    default String conditionalAll(String verb, Voice voice) {
        switch(voice) {
            default:
            case FIRST:
                return verb + "ía";
            case SECOND:
                return verb + "ías";
            case THIRD_MALE:
            case THIRD_FEMALE:
            case THIRD_FORMAL:
                return verb + "ía";
            case FIRST_PLURAL:
                return verb + "íamos";
            case SECOND_PLURAL:
                return verb + "íais";
            case THIRD_PL_FEMALE:
            case THIRD_PL_MALE:
            case THIRD_PL_FORMAL:
                return verb + "ían";
        }
    }

    default String futureAll(String verb, Voice voice) {
        switch(voice) {
            default:
            case FIRST:
                return verb + "é";
            case SECOND:
                return verb + "ás";
            case THIRD_MALE:
            case THIRD_FEMALE:
            case THIRD_FORMAL:
                return verb + "á";
            case FIRST_PLURAL:
                return verb + "emos";
            case SECOND_PLURAL:
                return verb + "éis";
            case THIRD_PL_FEMALE:
            case THIRD_PL_MALE:
            case THIRD_PL_FORMAL:
                return verb + "án";
        }
    }

    default String verbRootWithSuffix(String verb, String suffix) {
        StringBuilder sb = new StringBuilder(verb);
        int idx = verb.length() - 2;
        sb.replace(idx, idx + 2, suffix);
        return sb.toString();
    }

    @FunctionalInterface
    public interface WriteCard {
        void write(String english, String language);
    }
}

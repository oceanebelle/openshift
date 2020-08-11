package com.oceanebelle.generator.spanishcard.database;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Word {
    @Id
    private String id;

    private String enSingle;
    private String enPlural;
    private String enPast;
    private String ing;

    private String esSingle;
    private String esPlural;

    @Enumerated(EnumType.STRING)
    private WordType type;

    private String subject;

    public enum WordType {
        VERB
    }
}

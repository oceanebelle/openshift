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
public class Conjugation {
    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    private ConjugationType type;

    private String first;
    private String second;
    private String third;

    private String firstPlural;
    private String secondPlural;
    private String thirdPlural;

    public enum ConjugationType {
        IPRESENT,
        IPRETERITE,
        IIMPERFECT,
        ICONDITIONAL,
        IFUTURE
    }
}

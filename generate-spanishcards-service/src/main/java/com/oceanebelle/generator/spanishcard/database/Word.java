package com.oceanebelle.generator.spanishcard.database;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
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

    private String type;
}

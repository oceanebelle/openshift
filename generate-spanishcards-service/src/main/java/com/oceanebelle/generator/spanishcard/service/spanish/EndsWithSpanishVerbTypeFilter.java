package com.oceanebelle.generator.spanishcard.service.spanish;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.Validate;

@AllArgsConstructor
public class EndsWithSpanishVerbTypeFilter implements SpanishVerbTypeFilter {
    private String suffix;

    @Override
    public boolean test(String verb) {
        Validate.notBlank(verb);
        return verb.toUpperCase().endsWith(suffix.toUpperCase());
    }
}

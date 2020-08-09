package com.oceanebelle.generator.spanishcard.service.spanish;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.Validate;

import java.util.List;

@AllArgsConstructor
public class EqualsSpanishVerbTypeFilter implements SpanishVerbTypeFilter {
    private List<String> verbs;

    @Override
    public boolean test(final String other) {
        Validate.notBlank(other);
        return verbs
                .stream()
                .anyMatch(v -> v.equalsIgnoreCase(other));
    }
}

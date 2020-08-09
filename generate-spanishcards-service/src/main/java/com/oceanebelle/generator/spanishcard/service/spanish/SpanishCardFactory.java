package com.oceanebelle.generator.spanishcard.service.spanish;

public interface SpanishCardFactory {
    SpanishCardGenerator getGeneratorFor(String verb);
}

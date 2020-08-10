package com.oceanebelle.generator.spanishcard.service.spanish;


import java.io.IOException;
import java.io.InputStream;

public interface GenerateSpanishCardService {
    InputStream writeCards(String verb, String subject) throws IOException;
}

package com.oceanebelle.generator.spanishcard.controllers;

import com.oceanebelle.generator.spanishcard.service.spanish.GenerateSpanishCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequiredArgsConstructor
public class GenerateSpanishCardApiController {

    private final GenerateSpanishCardService spanishCardService;

    /**
     * There are three types of verbs in Spanish and they're categorized by their endings.
     * There are -AR verbs (like hablar), -ER verbs (like beber) and -IR verbs (like vivir).
     *
     * It is also possible to have irregular verbs
     * @return
     */
    @GetMapping(value = "/api/v1/cards/{verb}/{word}/{subject}")
    ResponseEntity<Resource> getCardsForVerbAsCSV(
            @PathVariable("verb") String verb,
            @PathVariable("word") String word,
            @PathVariable("subject") String subject
    ) throws IOException {
        InputStream inputStream = spanishCardService.writeCards(verb, word, subject);

        InputStreamResource isr = new InputStreamResource(inputStream);
        HttpHeaders headers = new HttpHeaders();

        String downloadFileName = "spanish.csv";

        headers.setContentDisposition(
                ContentDisposition.builder("inline")
                        .filename(downloadFileName)
                        .build());

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .cacheControl(CacheControl.noCache())
                .body(isr);
    }


}

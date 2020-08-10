package com.oceanebelle.generator.spanishcard.controllers;

import com.oceanebelle.generator.spanishcard.service.spanish.GenerateSpanishCardService;
import com.oceanebelle.generator.spanishcard.service.spanish.WordService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class GenerateSpanishCardApiController {

    private final GenerateSpanishCardService spanishCardService;
    private final WordService wordService;

    /**
     * There are three types of verbs in Spanish and they're categorized by their endings.
     * There are -AR verbs (like hablar), -ER verbs (like beber) and -IR verbs (like vivir).
     *
     * It is also possible to have irregular verbs
     * @return
     */
    @GetMapping(value = "/api/v1/cards/{verb}/{subject}")
    ResponseEntity<Resource> getCardsForVerbAsCSV(
            @PathVariable("verb") String verb,
            @PathVariable("subject") String subject
    ) throws IOException {
        InputStream inputStream = spanishCardService.writeCards(verb, subject);

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

    @GetMapping(value = "/api/v1/cards/all/{subject}")
    ResponseEntity<Map<String, ?>> getWords(
            @PathVariable("subject") String subject
    ) {
        var data = new HashMap<String, Object>();

        data.computeIfAbsent("urls", x -> wordService.getVerbs()
                .stream()
                .map(s -> new Data(s.getValue(), "/api/v1/cards/" + s.getKey() + "/" + subject))
                .collect(Collectors.toList()));

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .cacheControl(CacheControl.noCache())
                .body(data);
    }

}

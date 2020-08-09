package com.oceanebelle.generator.spanishcard.controllers;

import com.oceanebelle.generator.spanishcard.service.DummyDataGeneratingService;
import com.oceanebelle.generator.spanishcard.service.GenerateSpanishCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GenerateSpanishCardApiController {

    private final GenerateSpanishCardService spanishCardService;

    /**
     * There are three types of verbs in Spanish and they're categorized by their endings.
     * There are -AR verbs (like hablar), -ER verbs (like beber) and -IR verbs (like vivir).
     * @return
     */
    @GetMapping(value = "/api/v1/cards/{verb}/csv")
    ResponseEntity<Resource> getCardsForVerbAsCSV(
            @PathVariable("verb") String verb
    ) {
        HttpHeaders headers = new HttpHeaders();



//        return ResponseEntity.ok()
//                .headers(headers)
//                .contentLength(file.length())
//                .contentType(MediaType.APPLICATION_OCTET_STREAM)
//                .body(resource);

        // TODO: Generate

        throw new UnsupportedOperationException("TBD");
    }


}

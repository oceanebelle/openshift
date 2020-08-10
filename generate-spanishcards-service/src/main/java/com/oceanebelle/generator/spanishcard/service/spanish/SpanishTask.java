package com.oceanebelle.generator.spanishcard.service.spanish;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

@AllArgsConstructor
@Log4j2
class SpanishTask implements Runnable {
    private SpanishCardGenerator generator;
    private OutputStream output;
    private String verb;
    private String subject;

    @Override
    public void run() {
        try(final var source = new BufferedOutputStream(output, 1024)) {
            generator.printCard(verb, subject, (en, es) -> {
                StringBuilder sb = new StringBuilder();
                sb.append(en);
                sb.append(",");
                sb.append(es);
                sb.append("\n");
                try {
                    source.write(sb.toString().getBytes(StandardCharsets.UTF_8));
                } catch (IOException e) {
                    log.error("Failed to write {}={}", en, es);
                }
            });
            source.flush();
        } catch (Exception e) {
            log.error("Failed writing task", e);
        }
    }
}

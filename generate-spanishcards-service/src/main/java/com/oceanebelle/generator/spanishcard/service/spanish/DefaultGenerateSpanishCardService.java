package com.oceanebelle.generator.spanishcard.service.spanish;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.ExecutorService;

@Service
@Log4j2
public class DefaultGenerateSpanishCardService implements GenerateSpanishCardService {

    private final ExecutorService executorService;

    private final SpanishCardFactory factory;


    public DefaultGenerateSpanishCardService(@Qualifier("spanishExecutor") ExecutorService executorService,
                                             SpanishCardFactory factory) {
        this.executorService = executorService;
        this.factory = factory;
    }

    @Override
    public InputStream writeCards(String verb, String subject) throws IOException {

        SpanishCardGenerator generator = factory.getGeneratorFor(verb);

        PipedInputStream sink = new PipedInputStream();
        PipedOutputStream source = new PipedOutputStream();
        source.connect(sink);

        SpanishTask task = new SpanishTask(generator, source, verb, subject);
        executorService.submit(task);

        return sink;
    }

}


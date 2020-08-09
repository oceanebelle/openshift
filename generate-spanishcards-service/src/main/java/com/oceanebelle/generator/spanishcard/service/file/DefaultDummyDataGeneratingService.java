package com.oceanebelle.generator.spanishcard.service.file;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;

@Service
@Log4j2
public class DefaultDummyDataGeneratingService implements DummyDataGeneratingService {


    private final ExecutorService executorService;

    public DefaultDummyDataGeneratingService(@Qualifier("dummyExecutor") ExecutorService executorService) {
        this.executorService = executorService;
    }

    @Override
    public InputStream write(int sizeInMb) throws IOException {

        PipedInputStream sink = new PipedInputStream();
        PipedOutputStream source = new PipedOutputStream();
        source.connect(sink);

        Instant requested = Instant.now();
        log.info("Requesting a file of size {}Mb", sizeInMb);

        executorService.submit(new GenerateTask(source, sizeInMb, requested));

        return sink;
    }

    @AllArgsConstructor
    private static class GenerateTask implements Runnable {

        private OutputStream out;
        private int sizeInMb;
        private Instant requested;

        private static final int bufferSize = 1024;
        private static final int MB = 1024 * 1024;

        @Override
        public void run() {
            try {

                log.info("File generation started. {} ms elapsed since original request", getElapsedInMSSince(requested));

                final byte[] line = "The quick brown fox jumps over the lazy dog by the river bank. \n".getBytes(StandardCharsets.UTF_8);
                try (BufferedOutputStream os = new BufferedOutputStream(out, bufferSize)) {
                    for(long max = sizeInMb * MB, size = 0, count = 0; size < max; size += line.length, count++) {
                        os.write(line);
                        if (count % 100 == 0) {
                            os.flush();
                            log.debug("Memory usage: {}", getMemoryUsage());
                        }
                    }
                    os.flush();
                }

                log.info("Memory usage: {}", getMemoryUsage());
                log.info("File generated completed. took {} ms", getElapsedInMSSince(requested));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static long getMemoryUsage() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    private static long getElapsedInMSSince(Instant checkpoint) {
        Duration duration = Duration.between(checkpoint, Instant.now());
        return duration.toMillis();
    }

}

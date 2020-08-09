package com.oceanebelle.generator.spanishcard.service.file;

import java.io.IOException;
import java.io.InputStream;

public interface DummyDataGeneratingService {
    InputStream write(int sizeInMb) throws IOException;
}

package com.oceanebelle.generator.spanishcard.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class ServicesConfiguration {

    @Bean @Qualifier("dummyExecutor")
    ExecutorService dummyExecutorService() {
        var factory = Executors.defaultThreadFactory();

        ExecutorService executor = Executors.newFixedThreadPool(5, factory);

        return executor;
    }

}

package com.oceanebelle.generator.spanishcard.service;

import io.micrometer.core.aop.CountedAspect;
import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.aspectj.lang.annotation.Aspect;
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

        ExecutorService executor = Executors.newFixedThreadPool(1, factory);

        return executor;
    }

    @Bean @Qualifier("spanishExecutor")
    ExecutorService spanishExecutor() {
        var factory = Executors.defaultThreadFactory();

        ExecutorService executor = Executors.newFixedThreadPool(5, factory);

        return executor;
    }

    @Bean
    public TimedAspect timedAspect(MeterRegistry registry) {
        return new TimedAspect(registry);
    }

    @Bean
    public CountedAspect countedAspect(MeterRegistry registry) {
        return new CountedAspect(registry);
    }

}

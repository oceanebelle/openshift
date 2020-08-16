package com.oceanebelle.mock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Value("${mock.port:8080}")
    private int mockPort;

    @Value("${mock.dir:mocking-service/src/main/resources}")
    private String mockDir;

    @Bean
    public WireMockServer wireMockServer() {
        WireMockConfiguration config = new WireMockConfiguration();
        config.port(mockPort);
        config.usingFilesUnderDirectory(mockDir);
        return new WireMockServer(config);
    }
}

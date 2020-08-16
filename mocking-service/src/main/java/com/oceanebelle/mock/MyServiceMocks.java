package com.oceanebelle.mock;

import com.github.tomakehurst.wiremock.WireMockServer;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;


@Component
@DependsOn("mockinit")
@AllArgsConstructor
@Log4j2
public class MyServiceMocks implements InitializingBean {

    private static final String STARTED = "Started"; // Wiremock begin state

    private WireMockServer mockServer;
    @Override
    public void afterPropertiesSet() throws Exception {

        log.info("Mocked the echo service");
        // See Wiremock pages for more involved test cases
        configureFor("localhost", mockServer.port());
        stubFor(get(urlEqualTo("/echo"))
            .willReturn(
                    aResponse()
                            .withHeader("Content-Type","application/json")
                            .withStatus(200)
                            .withBodyFile("echo.json")
                    ));

        // fetch /__admin/scenarios
        stubFor(get(urlEqualTo("/authorize?id=1000"))
                .inScenario("SCENARIO-VALID-USER")
                .whenScenarioStateIs(STARTED)
                .willReturn(
                        aResponse()
                                .withHeader("Content-Type","application/json")
                                .withStatus(200)
                                .withBodyFile("valid-user-authorized.json")
                )
                .willSetStateTo("SESSION-STARTED"));

        stubFor(get(urlEqualTo("/records?sid=123"))
                .inScenario("SCENARIO-VALID-USER")
                .whenScenarioStateIs("SESSION-STARTED")
                .willReturn(
                        aResponse()
                                .withHeader("Content-Type","application/json")
                                .withStatus(200)
                                .withBodyFile("valid-user-fetched-records.json")
                )
                .willSetStateTo("RECORDS-FETCHED"));

    }
}

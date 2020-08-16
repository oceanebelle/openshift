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

    private WireMockServer mockServer;
    @Override
    public void afterPropertiesSet() throws Exception {

        log.info("Mocked the echo service");
        configureFor("localhost", mockServer.port());
        stubFor(get(urlEqualTo("/echo"))
            .willReturn(
                    aResponse()
                            .withHeader("Content-Type","application/json")
                            .withStatus(200)
                            .withBodyFile("echo.json")
                            //.withBody("{\"hello\" : \"echo\"}").withTransformers())
                    ));

    }
}

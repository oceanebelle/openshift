package com.oceanebelle.mock;

import com.github.tomakehurst.wiremock.WireMockServer;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;


@Component("mockinit")
@AllArgsConstructor
@Log4j2
public class MockInit implements InitializingBean {

    private WireMockServer mockService;

    @Override
    public void afterPropertiesSet() throws Exception {
        mockService.start();
        log.info("Started Mock service");
    }


    @PreDestroy
    public void cleanup() {
        mockService.stop();
        log.info("Stopping mock service");
    }


}

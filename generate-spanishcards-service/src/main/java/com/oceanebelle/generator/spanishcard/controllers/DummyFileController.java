package com.oceanebelle.generator.spanishcard.controllers;

import com.oceanebelle.generator.spanishcard.service.DummyDataGeneratingService;
import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Log4j2
@Timed
public class DummyFileController {

    private DummyDataGeneratingService dummyService;


    @GetMapping(value = "/api/v1/file/{sizeInMb}")
    ResponseEntity<Resource> downloadFile(
            @PathVariable("sizeInMb") int sizeInMb,
            @RequestParam(value = "filename", required = false) String fileName
    ) throws IOException {

        InputStream inputStream = dummyService.write(sizeInMb);

        InputStreamResource isr = new InputStreamResource(inputStream);
        HttpHeaders headers = new HttpHeaders();

        String downloadFileName = StringUtils.defaultIfBlank(fileName, "dummy.txt");

        headers.setContentDisposition(
                ContentDisposition.builder("attachment")
                        .filename(downloadFileName)
                        .build());

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .cacheControl(CacheControl.noCache())
                .body(isr);
    }

}

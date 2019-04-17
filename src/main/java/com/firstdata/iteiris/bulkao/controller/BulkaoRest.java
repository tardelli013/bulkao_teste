package com.firstdata.iteiris.bulkao.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Api(value="Bulkao Management System", description="Operations pertaining to Bulkao")
@RequestMapping("/api")
public class BulkaoRest {

    @ApiOperation(value = "Lorem ipsum",
            notes = "Lorem ipsum test",
            response = String.class)
    @GetMapping(value = "/test/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<Integer, String>> endpointTest() {
        Map<Integer, String> mapa = new HashMap<>();
        String test = "Hello World";

        for (int i = 1; i < 501; i++) {
            mapa.put(i, test + " - " + i);
        }

        mapa.forEach((integer, s) -> System.out.println(s));

        return new ResponseEntity<>(mapa, HttpStatus.OK);
    }

}

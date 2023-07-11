package com.sunpower.controller;

import com.sunpower.dto.Response;
import com.sunpower.dto.SolarUnitsRequest;
import com.sunpower.service.SolarUnitsServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register-solar_units")
public class SolarUnitsController {

    @Autowired
    private SolarUnitsServ solarUnitsServ;

    @PostMapping
    public ResponseEntity<Response> registerProduct(@RequestBody SolarUnitsRequest solarUnitsRequest) {
        return solarUnitsServ.registerUnit(solarUnitsRequest);

    }
}

package com.sunpower.service;

import com.sunpower.dto.Response;
import com.sunpower.dto.SolarUnitsRequest;
import org.springframework.http.ResponseEntity;

public interface SolarUnitsServ {
    ResponseEntity<Response> registerUnit(SolarUnitsRequest solarUnitsRequest);
}

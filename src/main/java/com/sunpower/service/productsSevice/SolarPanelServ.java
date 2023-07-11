package com.sunpower.service.productsSevice;

import com.sunpower.dto.productsDto.SolarPanelRequest;
import com.sunpower.dto.Response;
import org.springframework.http.ResponseEntity;

public interface SolarPanelServ {
    ResponseEntity<Response> registerSolarPanels(SolarPanelRequest solarPanelRequest);
}

package com.sunpower.ProductSevice;

import com.sunpower.ProductDto.SolarPanelRequest;
import com.sunpower.dto.Response;
import org.springframework.http.ResponseEntity;

public interface SolarServ {
    ResponseEntity<Response> registerSolarPanels(SolarPanelRequest solarPanelRequest);
}

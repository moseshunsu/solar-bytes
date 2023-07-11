package com.sunpower.ProductController;

import com.sunpower.ProductDto.MountingStructureRequest;
import com.sunpower.ProductDto.SolarPanelRequest;
import com.sunpower.ProductResponse.Response;
import com.sunpower.ProductSevice.SolarServ;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("solarPanels")
public class SolarPanelsController {
    public final SolarServ solarServ;

    public SolarPanelsController(SolarServ solarServ) {
        this.solarServ = solarServ;
    }
    @PostMapping
    public ResponseEntity<Response> registerSolarPanels(@RequestBody SolarPanelRequest solarPanelRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(solarServ.registerSolarPanels(solarPanelRequest));
    }
}
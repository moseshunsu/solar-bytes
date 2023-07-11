package com.sunpower.ProductController;

import com.sunpower.ProductDto.SolarPanelRequest;
import com.sunpower.ProductSevice.SolarPanelServ;
import com.sunpower.dto.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("solarPanels")
public class SolarPanelsController {
    public final SolarPanelServ solarPanelServ;

    public SolarPanelsController(SolarPanelServ solarPanelServ) {
        this.solarPanelServ = solarPanelServ;
    }

    @PostMapping
    public ResponseEntity<Response> registerSolarPanels(@RequestBody SolarPanelRequest solarPanelRequest) {
        return solarPanelServ.registerSolarPanels(solarPanelRequest);
    }
}

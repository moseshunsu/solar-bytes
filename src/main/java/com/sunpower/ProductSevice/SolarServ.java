package com.sunpower.ProductSevice;

import com.sunpower.ProductDto.SolarPanelRequest;
import com.sunpower.ProductResponse.Response;

public interface SolarServ {
    Response registerSolarPanels(SolarPanelRequest solarPanelRequest);
}

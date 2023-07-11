package com.sunpower.ProductServImpl;

import com.sunpower.ProductDto.BatteryRequest;
import com.sunpower.ProductDto.SolarPanelRequest;
import com.sunpower.ProductRepo.SolarRepo;
import com.sunpower.ProductResponse.Response;
import com.sunpower.ProductSevice.SolarServ;
import com.sunpower.Products.Battery;
import com.sunpower.Products.SolarPanels;
import org.springframework.stereotype.Service;

@Service
public class SolarPanelsImpl implements SolarServ {
    private final SolarRepo solarRepo;

    public SolarPanelsImpl(SolarRepo solarRepo) {
        this.solarRepo = solarRepo;
    }

    @Override
    public Response registerSolarPanels(SolarPanelRequest solarPanelRequest) {
        boolean isSolarPanelsExist= solarRepo.existsByName(solarPanelRequest.getName());
        if (isSolarPanelsExist){
            return Response.builder()
                    .responseCode(com.sunpower.ProductUtils.ResponseUtils.PRODUCT_EXISTS_CODE)
                    .responseMessage(com.sunpower.ProductUtils.ResponseUtils.PRODUCT_EXISTS_MESSAGE)
                    .build();
        }
        SolarPanels solarPanels = SolarPanels.builder()
                .name(solarPanelRequest.getName())
                .ratingVoltage(solarPanelRequest.getRatingVoltage())
                .ratingWattage(solarPanelRequest.getRatingWattage())
                .productWarranty(solarPanelRequest.getProductWarranty())
                .amount(solarPanelRequest.getAmount())
                .build();

        SolarPanels savedSolarPanels=solarRepo.save(solarPanels);

        return Response.builder()
                .responseCode(com.sunpower.ProductUtils.ResponseUtils.SUCCESS)
                .responseMessage(com.sunpower.ProductUtils.ResponseUtils.PRODUCT_SUCCESS_MESSAGE)
                .build();

    }
}

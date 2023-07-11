package com.sunpower.ProductServImpl;

import com.sunpower.ProductDto.SolarPanelRequest;
import com.sunpower.ProductRepo.SolarRepo;
import com.sunpower.ProductSevice.SolarServ;
import com.sunpower.Products.SolarPanels;
import com.sunpower.dto.Response;
import com.sunpower.utils.ResponseUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SolarPanelsImpl implements SolarServ {
    private final SolarRepo solarRepo;

    public SolarPanelsImpl(SolarRepo solarRepo) {
        this.solarRepo = solarRepo;
    }

    @Override
    public ResponseEntity<Response> registerSolarPanels(SolarPanelRequest solarPanelRequest) {

        boolean isSolarPanelsExist= solarRepo.existsByName(solarPanelRequest.getName());

        if (isSolarPanelsExist){
            return ResponseEntity.badRequest().body(Response.builder()
                    .responseCode(ResponseUtils.PRODUCT_EXISTS_CODE)
                    .responseMessage(ResponseUtils.PRODUCT_EXISTS_MESSAGE)
                    .build());
        }

        SolarPanels solarPanels = SolarPanels.builder()
                .name(solarPanelRequest.getName())
                .ratingVoltage(solarPanelRequest.getRatingVoltage())
                .ratingWattage(solarPanelRequest.getRatingWattage())
                .productWarranty(solarPanelRequest.getProductWarranty())
                .amount(solarPanelRequest.getAmount())
                .build();

        SolarPanels savedSolarPanels=solarRepo.save(solarPanels);

        return ResponseEntity.ok(Response.builder()
                .responseCode(ResponseUtils.SUCCESS)
                .responseMessage(ResponseUtils.PRODUCT_SUCCESS_MESSAGE)
                .build());

    }

}

package com.sunpower.service.impl.productsServImpl;

import com.sunpower.dto.productsDto.SolarPanelRequest;
import com.sunpower.repository.ProductsRepo.SolarRepo;
import com.sunpower.service.productsSevice.SolarPanelServ;
import com.sunpower.entity.products.SolarPanels;
import com.sunpower.dto.Response;
import com.sunpower.utils.ResponseUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SolarPanelsImpl implements SolarPanelServ {
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
                .src(solarPanelRequest.getSrc())
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

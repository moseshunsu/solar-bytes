package com.sunpower.service.impl;

import com.sunpower.dto.Response;
import com.sunpower.dto.SolarUnitsRequest;
import com.sunpower.entity.SolarUnits;
import com.sunpower.repository.SolarUnitsRepo;
import com.sunpower.service.SolarUnitsServ;
import com.sunpower.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SolarUnitsServImpl implements SolarUnitsServ {
    @Autowired
    private SolarUnitsRepo solarUnitsRepo;

    @Override
    public ResponseEntity<Response> registerUnit(SolarUnitsRequest solarUnitsRequest) {

        boolean isUnitsExist= solarUnitsRepo.existsByUnits(solarUnitsRequest.getUnits());

        if (isUnitsExist) {
            return ResponseEntity.badRequest().body(Response.builder()
                    .responseCode(ResponseUtils.PRODUCT_EXISTS_CODE)
                    .responseMessage(ResponseUtils.PRODUCT_EXISTS_MESSAGE)
                    .build());
        }

        SolarUnits solarUnit = SolarUnits.builder()
                .units(solarUnitsRequest.getUnits())
                .amount(solarUnitsRequest.getAmount())
                .description(solarUnitsRequest.getDescription())
                .build();

        SolarUnits savedSolarUnit = solarUnitsRepo.save(solarUnit);

        return ResponseEntity.ok(Response.builder()
                .responseCode(ResponseUtils.PRODUCT_SUCCESS_CODE)
                .responseMessage(ResponseUtils.PRODUCT_SUCCESS_MESSAGE)
                .build());

    }

}

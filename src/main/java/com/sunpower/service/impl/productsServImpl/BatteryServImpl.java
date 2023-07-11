package com.sunpower.service.impl.productsServImpl;

import com.sunpower.dto.productsDto.BatteryRequest;
import com.sunpower.repository.ProductsRepo.BatteryRepo;
import com.sunpower.service.productsSevice.BatteryServ;
import com.sunpower.entity.products.Battery;
import com.sunpower.dto.Response;
import com.sunpower.utils.ResponseUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BatteryServImpl implements BatteryServ {
    private final BatteryRepo batteryRepo ;

    public BatteryServImpl(BatteryRepo batteryRepo) {
        this.batteryRepo = batteryRepo;
    }

    @Override
    public ResponseEntity<Response> registerBattery(BatteryRequest batteryRequest) {

        boolean isBatteryExist= batteryRepo.existsByName(batteryRequest.getName());

        if (isBatteryExist){
            return ResponseEntity.badRequest().body(Response.builder()
                    .responseCode(ResponseUtils.PRODUCT_EXISTS_CODE)
                    .responseMessage(ResponseUtils.PRODUCT_EXISTS_MESSAGE)
                    .build());

        }
        Battery battery=Battery.builder()
                .name(batteryRequest.getName())
                .standardVoltage(batteryRequest.getStandardVoltage())
                .productWarranty(batteryRequest.getProductWarranty())
                .workingVoltage(batteryRequest.getWorkingVoltage())
                .amount(batteryRequest.getAmount())
                .build();

        Battery savedBattery=batteryRepo.save(battery);

        return ResponseEntity.ok(Response.builder()
                .responseCode(ResponseUtils.SUCCESS)
                .responseMessage(ResponseUtils.PRODUCT_SUCCESS_MESSAGE)
                .build());

    }

}

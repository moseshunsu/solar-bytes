package com.sunpower.ProductServImpl;

import com.sunpower.ProductDto.BatteryRequest;
import com.sunpower.ProductRepo.BatteryRepo;
import com.sunpower.ProductResponse.Response;
import com.sunpower.ProductSevice.BatteryServ;
import com.sunpower.Products.Battery;
import org.springframework.stereotype.Service;

@Service
public class BatteryServImpl implements BatteryServ {
    private final BatteryRepo batteryRepo ;

    public BatteryServImpl(BatteryRepo batteryRepo) {
        this.batteryRepo = batteryRepo;
    }


    @Override
    public Response registerBattery(BatteryRequest batteryRequest) {
        boolean isBatteryExist= batteryRepo.existsByName(batteryRequest.getName());
        if (isBatteryExist){
            return Response.builder()
                    .responseCode(com.sunpower.ProductUtils.ResponseUtils.PRODUCT_EXISTS_CODE)
                    .responseMessage(com.sunpower.ProductUtils.ResponseUtils.PRODUCT_EXISTS_MESSAGE)
                    .build();

        }
        Battery battery=Battery.builder()
                .name(batteryRequest.getName())
                .componentEfficiency(batteryRequest.getComponentEfficiency())
                .productWarranty(batteryRequest.getProductWarranty())
                .componentPower(batteryRequest.getComponentPower())
                .build();

        Battery savedBattery=batteryRepo.save(battery);

        return Response.builder()
                .responseCode(com.sunpower.ProductUtils.ResponseUtils.SUCCESS)
                .responseMessage(com.sunpower.ProductUtils.ResponseUtils.PRODUCT_SUCCESS_MESSAGE)
                .build();

    }
}

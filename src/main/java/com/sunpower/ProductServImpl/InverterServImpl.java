package com.sunpower.ProductServImpl;

import com.sunpower.ProductDto.InverterRequest;
import com.sunpower.ProductRepo.InverterRepo;
import com.sunpower.ProductResponse.Response;
import com.sunpower.ProductSevice.InverterServ;
import com.sunpower.Products.Inverter;
import org.springframework.stereotype.Service;

@Service
public class InverterServImpl implements InverterServ {
    public final InverterRepo inverterRepo;

    public InverterServImpl(InverterRepo inverterRepo) {
        this.inverterRepo = inverterRepo;
}
    @Override
    public Response registerInverter(InverterRequest inverterRequest) {
        boolean isBatteryExist= inverterRepo.existsByName(inverterRequest.getName());
        if (isBatteryExist) {
            return Response.builder()
                    .responseCode(com.sunpower.ProductUtils.ResponseUtils.PRODUCT_EXISTS_CODE)
                    .responseMessage(com.sunpower.ProductUtils.ResponseUtils.PRODUCT_EXISTS_MESSAGE)
                    .build();
        }

            Inverter inverter = Inverter.builder()
                    .name(inverterRequest.getName())
                    .batteryVoltageRange(inverterRequest.getBatteryVoltageRange())
                    .componentEfficiency(inverterRequest.getComponentEfficiency())
                    .productWarranty(inverterRequest.getProductWarranty())
                    .amount(inverterRequest.getAmount())
                    .build();

            Inverter savedInverter=inverterRepo.save(inverter);

        return Response.builder()
                .responseCode(com.sunpower.ProductUtils.ResponseUtils.SUCCESS)
                .responseMessage(com.sunpower.ProductUtils.ResponseUtils.PRODUCT_SUCCESS_MESSAGE)
                .build();
    }
}

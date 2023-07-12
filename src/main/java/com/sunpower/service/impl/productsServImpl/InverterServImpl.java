package com.sunpower.service.impl.productsServImpl;

import com.sunpower.dto.productsDto.InverterRequest;
import com.sunpower.repository.ProductsRepo.InverterRepo;
import com.sunpower.service.productsSevice.InverterServ;
import com.sunpower.entity.products.Inverter;
import com.sunpower.dto.Response;
import com.sunpower.utils.ResponseUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class InverterServImpl implements InverterServ {
    public final InverterRepo inverterRepo;

    public InverterServImpl(InverterRepo inverterRepo) {
        this.inverterRepo = inverterRepo;
}
    @Override
    public ResponseEntity<Response> registerInverter(InverterRequest inverterRequest) {

        boolean isInventorExist= inverterRepo.existsByName(inverterRequest.getName());

        if (isInventorExist) {
            return ResponseEntity.badRequest().body(Response.builder()
                    .responseCode(ResponseUtils.PRODUCT_EXISTS_CODE)
                    .responseMessage(ResponseUtils.PRODUCT_EXISTS_MESSAGE)
                    .build());
        }

        Inverter inverter = Inverter.builder()
                .name(inverterRequest.getName())
                .src(inverterRequest.getSrc())
                .batteryVoltageRange(inverterRequest.getBatteryVoltageRange())
                .componentEfficiency(inverterRequest.getComponentEfficiency())
                .productWarranty(inverterRequest.getProductWarranty())
                .amount(inverterRequest.getAmount())
                .build();

        Inverter savedInverter = inverterRepo.save(inverter);

        return ResponseEntity.ok(Response.builder()
                .responseCode(ResponseUtils.PRODUCT_SUCCESS_CODE)
                .responseMessage(ResponseUtils.PRODUCT_SUCCESS_MESSAGE)
                .build());

    }

}

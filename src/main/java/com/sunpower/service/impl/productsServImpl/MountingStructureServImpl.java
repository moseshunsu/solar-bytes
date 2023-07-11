package com.sunpower.service.impl.productsServImpl;

import com.sunpower.dto.productsDto.MountingStructureRequest;
import com.sunpower.repository.ProductsRepo.MountingStructureRepo;
import com.sunpower.service.productsSevice.MountingStructureServ;
import com.sunpower.entity.products.MountingStructure;
import com.sunpower.dto.Response;
import com.sunpower.utils.ResponseUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MountingStructureServImpl implements MountingStructureServ {
    public MountingStructureRepo mountingStructureRepo;

    public MountingStructureServImpl(MountingStructureRepo mountingStructureRepo) {
        this.mountingStructureRepo = mountingStructureRepo;
    }

    @Override
    public ResponseEntity<Response> registerMountingStructure(MountingStructureRequest mountingStructureRequest) {

        boolean isMountingStructureExist = mountingStructureRepo.existsByModel(mountingStructureRequest.getModel());

        if (isMountingStructureExist) {
            return ResponseEntity.badRequest().body(Response.builder()
                    .responseCode(ResponseUtils.PRODUCT_EXISTS_CODE)
                    .responseMessage(ResponseUtils.PRODUCT_EXISTS_MESSAGE)
                    .build());
        }

        MountingStructure mountingStructure = MountingStructure.builder()
                .model(mountingStructureRequest.getModel())
                .material(mountingStructureRequest.getMaterial())
                .serviceLife(mountingStructureRequest.getServiceLife())
                .warranty(mountingStructureRequest.getWarranty())
                .amount(mountingStructureRequest.getAmount())
                .build();

        MountingStructure savedMountingStructure = mountingStructureRepo.save(mountingStructure);

        return ResponseEntity.ok(Response.builder()
                .responseCode(ResponseUtils.SUCCESS)
                .responseMessage(ResponseUtils.PRODUCT_SUCCESS_MESSAGE)
                .build());

    }

}

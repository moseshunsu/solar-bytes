package com.sunpower.ProductServImpl;

import com.sunpower.ProductDto.MountingStructureRequest;
import com.sunpower.ProductRepo.MountingStructureRepo;
import com.sunpower.ProductResponse.Response;
import com.sunpower.ProductSevice.MountingStructureServ;
import com.sunpower.Products.MountingStructure;
import org.springframework.stereotype.Service;

@Service
public class MountingStructureServImpl implements MountingStructureServ {
    public MountingStructureRepo mountingStructureRepo;

    public MountingStructureServImpl(MountingStructureRepo mountingStructureRepo) {
        this.mountingStructureRepo = mountingStructureRepo;
    }

    @Override
    public Response registerMountingStructure(MountingStructureRequest mountingStructureRequest) {

        boolean isMountingStructureExist= mountingStructureRepo.existsByModel(mountingStructureRequest.getModel());
        if (isMountingStructureExist) {
            return Response.builder()
                    .responseCode(com.sunpower.ProductUtils.ResponseUtils.PRODUCT_EXISTS_CODE)
                    .responseMessage(com.sunpower.ProductUtils.ResponseUtils.PRODUCT_EXISTS_MESSAGE)
                    .build();
        }

        MountingStructure mountingStructure = MountingStructure.builder()
                .model(mountingStructureRequest.getModel())
                .material(mountingStructureRequest.getMaterial())
                .serviceLife(mountingStructureRequest.getServiceLife())
                .warranty(mountingStructureRequest.getWarranty())
                .amount(mountingStructureRequest.getAmount())
                .build();

     MountingStructure savedMountingStructure=mountingStructureRepo.save(mountingStructure);

        return Response.builder()
                .responseCode(com.sunpower.ProductUtils.ResponseUtils.SUCCESS)
                .responseMessage(com.sunpower.ProductUtils.ResponseUtils.PRODUCT_SUCCESS_MESSAGE)
                .build();
    }
}

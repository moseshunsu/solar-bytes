package com.sunpower.ProductServImpl;

import com.sunpower.ProductDto.MountingStructureRequest;
import com.sunpower.ProductRepo.MountingStructureRepo;
import com.sunpower.ProductResponse.Response;
import com.sunpower.ProductSevice.MountingStructureServ;
import com.sunpower.Products.MountingStructure;
import com.sunpower.utils.ResponseUtils;
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
                    .responseCode(ResponseUtils.PRODUCT_EXISTS_CODE)
                    .responseMessage(ResponseUtils.PRODUCT_EXISTS_MESSAGE)
                    .build();
        }

        MountingStructure mountingStructure = MountingStructure.builder()
                .model(mountingStructureRequest.getModel())
                .material(mountingStructureRequest.getMaterial())
                .serviceLife(mountingStructureRequest.getServiceLife())
                .warranty(mountingStructureRequest.getWarranty())
                .amount(mountingStructureRequest.getAmount())
                .build();

     MountingStructure savedMountingStructure = mountingStructureRepo.save(mountingStructure);

        return Response.builder()
                .responseCode(ResponseUtils.SUCCESS)
                .responseMessage(ResponseUtils.PRODUCT_SUCCESS_MESSAGE)
                .build();
    }
}

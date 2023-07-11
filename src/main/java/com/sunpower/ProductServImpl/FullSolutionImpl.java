package com.sunpower.ProductServImpl;

import com.sunpower.ProductDto.FullSolutionRequest;
import com.sunpower.ProductRepo.FullSolutionRepo;
import com.sunpower.ProductResponse.Response;
import com.sunpower.ProductSevice.FullSolutionServ;
import com.sunpower.Products.FullSolution;
import com.sunpower.Products.Inverter;
import org.springframework.stereotype.Service;

@Service
public class FullSolutionImpl implements FullSolutionServ {
    public final FullSolutionRepo fullSolutionRepo;

    public FullSolutionImpl(FullSolutionRepo fullSolutionRepo) {
        this.fullSolutionRepo = fullSolutionRepo;
    }

    @Override
    public Response registerFullSolution(FullSolutionRequest fullSolutionRequest) {
        boolean isFullSolutionExist= fullSolutionRepo.existsByName(fullSolutionRequest.getName());
        if (isFullSolutionExist) {
            return Response.builder()
                    .responseCode(com.sunpower.ProductUtils.ResponseUtils.PRODUCT_EXISTS_CODE)
                    .responseMessage(com.sunpower.ProductUtils.ResponseUtils.PRODUCT_EXISTS_MESSAGE)
                    .build();
        }

        FullSolution fullSolution= FullSolution.builder()
                .name(fullSolutionRequest.getName())
                .poweringLoads(fullSolutionRequest.getPoweringLoads())
                .specifications(fullSolutionRequest.getSpecifications())
                .amount(fullSolutionRequest.getAmount())
                .build();

        FullSolution savedFullSolution=fullSolutionRepo.save(fullSolution);

        return Response.builder()
                .responseCode(com.sunpower.ProductUtils.ResponseUtils.SUCCESS)
                .responseMessage(com.sunpower.ProductUtils.ResponseUtils.PRODUCT_SUCCESS_MESSAGE)
                .build();
    }
}

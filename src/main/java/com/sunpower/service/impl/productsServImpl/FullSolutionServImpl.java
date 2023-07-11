package com.sunpower.service.impl.productsServImpl;

import com.sunpower.dto.Response;
import com.sunpower.dto.productsDto.FullSolutionRequest;
import com.sunpower.entity.products.FullSolution;
import com.sunpower.repository.ProductsRepo.FullSolutionRepo;
import com.sunpower.service.productsSevice.FullSolutionServ;
import com.sunpower.utils.ResponseUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FullSolutionServImpl implements FullSolutionServ {
    public final FullSolutionRepo fullSolutionRepo;

    public FullSolutionServImpl(FullSolutionRepo fullSolutionRepo) {
        this.fullSolutionRepo = fullSolutionRepo;
    }

    @Override
    public ResponseEntity<Response> registerFullSolution(FullSolutionRequest fullSolutionRequest) {

        boolean isFullSolutionExist= fullSolutionRepo.existsByName(fullSolutionRequest.getName());

        if (isFullSolutionExist) {
            return ResponseEntity.badRequest().body(Response.builder()
                    .responseCode(ResponseUtils.PRODUCT_EXISTS_CODE)
                    .responseMessage(ResponseUtils.PRODUCT_EXISTS_MESSAGE)
                    .build());
        }

        FullSolution fullSolution= FullSolution.builder()
                .name(fullSolutionRequest.getName())
                .poweringLoads(fullSolutionRequest.getPoweringLoads())
                .specifications(fullSolutionRequest.getSpecifications())
                .amount(fullSolutionRequest.getAmount())
                .build();

        FullSolution savedFullSolution = fullSolutionRepo.save(fullSolution);

        return ResponseEntity.ok(Response.builder()
                .responseCode(ResponseUtils.SUCCESS)
                .responseMessage(ResponseUtils.PRODUCT_SUCCESS_MESSAGE)
                .build());
    }

}

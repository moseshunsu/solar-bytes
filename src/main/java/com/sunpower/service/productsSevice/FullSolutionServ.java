package com.sunpower.service.productsSevice;

import com.sunpower.dto.Response;
import com.sunpower.dto.productsDto.FullSolutionRequest;
import org.springframework.http.ResponseEntity;

public interface FullSolutionServ {
    ResponseEntity<Response> registerFullSolution(FullSolutionRequest fullSolutionRequest);
}

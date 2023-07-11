package com.sunpower.ProductSevice;

import com.sunpower.ProductDto.FullSolutionRequest;
import com.sunpower.ProductResponse.Response;

public interface FullSolutionServ {
    Response registerFullSolution(FullSolutionRequest fullSolutionRequest);
}

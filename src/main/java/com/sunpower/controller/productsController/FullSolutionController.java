package com.sunpower.controller.productsController;

import com.sunpower.dto.Response;
import com.sunpower.dto.productsDto.FullSolutionRequest;
import com.sunpower.service.productsSevice.FullSolutionServ;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fullSolution")
public class FullSolutionController {
    public final FullSolutionServ fullSolutionServ;

    public FullSolutionController(FullSolutionServ fullSolutionServ) {
        this.fullSolutionServ = fullSolutionServ;
    }

    @PostMapping
    public ResponseEntity<Response> registerFullSolution(@RequestBody FullSolutionRequest fullSolutionRequest) {
        return fullSolutionServ.registerFullSolution(fullSolutionRequest);
    }

}

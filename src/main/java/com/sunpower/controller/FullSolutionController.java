package com.sunpower.controller;

import com.sunpower.ProductDto.FullSolutionRequest;
import com.sunpower.ProductResponse.Response;
import com.sunpower.ProductSevice.FullSolutionServ;
import org.springframework.http.HttpStatus;
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
        return ResponseEntity.status(HttpStatus.CREATED).body(fullSolutionServ.registerFullSolution(fullSolutionRequest));
    }
}

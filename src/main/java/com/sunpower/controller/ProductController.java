package com.sunpower.controller;

import com.sunpower.dto.ProductRequest;
import com.sunpower.dto.Response;
import com.sunpower.service.ProductServ;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register-product")
public class ProductController {

    private final ProductServ productServ;

    public ProductController(ProductServ productServ) {
        this.productServ = productServ;
    }

    @PostMapping
    public ResponseEntity<Response> registerProduct(@RequestBody ProductRequest productRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productServ.registerProduct(productRequest));
    }

}

package com.sunpower.service.productsSevice;

import com.sunpower.dto.productsDto.InverterRequest;
import com.sunpower.dto.Response;
import org.springframework.http.ResponseEntity;

public interface InverterServ {
    ResponseEntity<Response> registerInverter(InverterRequest inverterRequest);
}

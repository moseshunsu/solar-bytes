package com.sunpower.ProductSevice;

import com.sunpower.ProductDto.InverterRequest;
import com.sunpower.dto.Response;
import org.springframework.http.ResponseEntity;

public interface InverterServ {
    ResponseEntity<Response> registerInverter(InverterRequest inverterRequest);
}

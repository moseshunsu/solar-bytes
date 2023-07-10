package com.sunpower.ProductSevice;

import com.sunpower.ProductDto.InverterRequest;
import com.sunpower.ProductResponse.Response;

public interface InverterServ {
    Response registerInverter(InverterRequest inverterRequest);
}

package com.sunpower.service.productsSevice;

import com.sunpower.dto.productsDto.MountingStructureRequest;
import com.sunpower.dto.Response;
import org.springframework.http.ResponseEntity;

public interface MountingStructureServ {
    ResponseEntity<Response> registerMountingStructure(MountingStructureRequest mountingStructureRequest);
}

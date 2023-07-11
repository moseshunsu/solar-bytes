package com.sunpower.ProductSevice;

import com.sunpower.ProductDto.MountingStructureRequest;
import com.sunpower.dto.Response;
import org.springframework.http.ResponseEntity;

public interface MountingStructureServ {
    ResponseEntity<Response> registerMountingStructure(MountingStructureRequest mountingStructureRequest);
}

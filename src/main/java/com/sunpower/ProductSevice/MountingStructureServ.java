package com.sunpower.ProductSevice;

import com.sunpower.ProductDto.MountingStructureRequest;
import com.sunpower.ProductResponse.Response;

public interface MountingStructureServ {
    Response registerMountingStructure(MountingStructureRequest mountingStructureRequest);
}

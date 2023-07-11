package com.sunpower.ProductController;


import com.sunpower.ProductDto.InverterRequest;
import com.sunpower.ProductDto.MountingStructureRequest;
import com.sunpower.ProductResponse.Response;
import com.sunpower.ProductSevice.MountingStructureServ;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mountingStructure")
public class MountingStructureController {
    public final MountingStructureServ mountingStructureServ;

    public MountingStructureController(MountingStructureServ mountingStructureServ) {
        this.mountingStructureServ = mountingStructureServ;
    }
    @PostMapping
    public ResponseEntity<Response> registerMountingStructure(@RequestBody MountingStructureRequest mountingStructureRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mountingStructureServ.registerMountingStructure
                (mountingStructureRequest));
    }
}

package com.sunpower.ProductController;

import com.sunpower.ProductDto.InverterRequest;
import com.sunpower.ProductSevice.InverterServ;
import com.sunpower.dto.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registerInverter")
public class InverterController {
    public  InverterServ inverterServ;

    public InverterController(InverterServ inverterServ) {
        this.inverterServ = inverterServ;
    }

    @PostMapping
    public ResponseEntity<Response> registerInverter(@RequestBody InverterRequest inverterRequest) {
        return inverterServ.registerInverter(inverterRequest);

    }
}

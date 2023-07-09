package com.sunpower.service;

import com.sunpower.dto.ProductRequest;
import com.sunpower.dto.Response;
import com.sunpower.entity.Product;

public interface ProductServ {
    Response registerProduct(ProductRequest productRequest);
}

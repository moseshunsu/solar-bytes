package com.sunpower.service.impl;

import com.sunpower.dto.ProductRequest;
import com.sunpower.dto.Response;
import com.sunpower.entity.Product;
import com.sunpower.repository.ProductRepo;
import com.sunpower.service.ProductServ;
import com.sunpower.utils.ResponseUtils;
import org.springframework.stereotype.Service;

@Service
public class ProductServImpl implements ProductServ {
    private  final ProductRepo productRepo;

    public ProductServImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Response registerProduct(ProductRequest productRequest) {
        boolean isProductExist= productRepo.existsByUnits(productRequest.getUnits());

        if (isProductExist) {
            return Response.builder()
                    .responseCode(ResponseUtils.PRODUCT_EXISTS_CODE)
                    .responseMessage(ResponseUtils.PRODUCT_EXISTS_MESSAGE)
                    .build();
        }

        Product product = Product.builder()
                .units(productRequest.getUnits())
                .amount(productRequest.getAmount())
                .description(productRequest.getDescription())
                .build();

        Product savedProduct = productRepo.save(product);

        return Response.builder()
                .responseCode(ResponseUtils.PRODUCT_SUCCESS_CODE)
                .responseMessage(ResponseUtils.PRODUCT_SUCCESS_MESSAGE)
                .build();

    }
}

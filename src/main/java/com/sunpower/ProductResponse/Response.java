package com.sunpower.ProductResponse;

import com.sunpower.dto.Data;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@lombok.Data
@Setter
@Getter
public class Response {
    private String responseCode;
    private String responseMessage;
    private Data data;
}

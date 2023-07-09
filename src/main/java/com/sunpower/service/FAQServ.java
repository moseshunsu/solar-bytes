package com.sunpower.service;

import com.sunpower.dto.FAQRequest;
import com.sunpower.dto.Response;

public interface FAQServ {
    Response registerFAQ(FAQRequest faqRequest);
}

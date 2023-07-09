package com.sunpower.service.impl;

import com.sunpower.dto.FAQRequest;
import com.sunpower.dto.Response;
import com.sunpower.entity.FAQ;
import com.sunpower.repository.FAQRepo;
import com.sunpower.service.FAQServ;
import com.sunpower.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FAQServImpl implements FAQServ {

    @Autowired
    private FAQRepo faqRepo;

    @Override
    public Response registerFAQ(FAQRequest faqRequest) {
        FAQ faq = FAQ.builder()
                .question(faqRequest.getQuestion())
                .answer(faqRequest.getAnswer()).build();

        return Response.builder()
                .responseCode(ResponseUtils.FAQ_SUCCESS_CODE)
                .responseMessage(ResponseUtils.FAQ_SUCCESS_MESSAGE)
                .build();
    }

}

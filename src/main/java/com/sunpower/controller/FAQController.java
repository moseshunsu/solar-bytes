package com.sunpower.controller;

import com.sunpower.dto.FAQRequest;
import com.sunpower.dto.Response;
import com.sunpower.service.FAQServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/faqs")
public class FAQController {

    @Autowired
    FAQServ faqServ;

    ResponseEntity<Response> registerFAQ(@RequestBody FAQRequest faqRequest) {
        return ResponseEntity.status(201).body(faqServ.registerFAQ(faqRequest));
    }

}

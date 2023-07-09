package com.sunpower.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FAQRequest {

    private String question;
    private String answer;

}

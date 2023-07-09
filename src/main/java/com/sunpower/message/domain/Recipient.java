package com.sunpower.message.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Recipient {

    private String firstName;
    private String lastName;
    private String phoneNumber;

}

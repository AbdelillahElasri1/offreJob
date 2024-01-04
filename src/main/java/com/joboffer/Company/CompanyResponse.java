package com.joboffer.Company;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyResponse {
    private Long id;
    private String password;
    private String address;
    private String email;
    private String phoneNumber;
    private byte[] image;
}

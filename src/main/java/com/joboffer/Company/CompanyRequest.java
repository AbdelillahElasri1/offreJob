package com.joboffer.Company;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class CompanyRequest {
    private String password;
    private String address;
    private String email;
    private String phoneNumber;
    private MultipartFile image;
}

package com.joboffer.Recruiter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecruiterRequest {
    private String name;
    private String email;
    private String phoneNumber;
    private Long company_id;
}

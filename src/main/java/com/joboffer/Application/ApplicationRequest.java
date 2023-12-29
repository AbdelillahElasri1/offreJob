package com.joboffer.Application;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class ApplicationRequest {
    private String applicantName;
    private String applicantEmail;
    private String cvAttachment;
    private LocalDateTime applicationDate;
    private Long job_offer_id;
}

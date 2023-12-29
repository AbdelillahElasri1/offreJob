package com.joboffer.Application;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ApplicationResponse {
    private Long id;
    private String applicantName;
    private String applicantEmail;
    private String cvAttachment;
    private LocalDateTime applicationDate;
}

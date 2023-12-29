package com.joboffer.JobOffer;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class JobOffreResponse {
    private Long id;
    private String title;
    private String description;
    private String profile;
    private String city;
    private String educationLevel;
    private BigDecimal salary;
    private String status;
}

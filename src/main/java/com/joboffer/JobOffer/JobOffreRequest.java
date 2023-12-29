package com.joboffer.JobOffer;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class JobOffreRequest {
    private String title;
    private String description;
    private String profile;
    private String city;
    private String educationLevel;
    private BigDecimal salary;
    private String status;
    private Long company_id;
    private Long agent_id;
}

package com.joboffer.JobOffer;

import com.joboffer.Agent.Agent;
import com.joboffer.Company.Company;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobOffre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

    private String title;
    private String description;
    private String profile;
    private String city;
    private String educationLevel;
    private BigDecimal salary;
    private String status;
}

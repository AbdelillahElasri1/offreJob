package com.joboffer.Application;

import com.joboffer.JobOffer.JobOffre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "job_offer_id")
    private JobOffre jobOffer;

    private String applicantName;
    private String applicantEmail;
    private String cvAttachment;
    private LocalDateTime applicationDate;
}

package com.joboffer.JobOffer;

import java.util.List;

public interface JobOffreService {
    JobOffreRequest createJobOffer(JobOffreRequest jobOffreRequest);
    JobOffreRequest updateJobOffer(JobOffreRequest jobOffreRequest);
    JobOffreResponse getOfferById(Long id);
    List<JobOffreResponse> getAllOffers();
    void deleteOffer(Long id);

}

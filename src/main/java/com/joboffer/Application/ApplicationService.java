package com.joboffer.Application;

import java.util.List;

public interface ApplicationService {
    ApplicationRequest createApplication(ApplicationRequest applicationRequest);
    ApplicationRequest updateApplication(ApplicationRequest applicationRequest);
    ApplicationResponse getApplicationById(Long id);
    List<ApplicationResponse> getAllApplications();
    void deleteApplication(Long id);

}

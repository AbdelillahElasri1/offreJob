package com.joboffer.Application;

import com.joboffer.JobOffer.JobOffre;
import com.joboffer.JobOffer.JobOffreRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImp implements ApplicationService{
    private final ApplicationRepository applicationRepository;
    private final JobOffreRepository offreRepository;
    private final ModelMapper modelMapper;
    @Override
    public ApplicationRequest createApplication(ApplicationRequest applicationRequest) {
        Application application = modelMapper.map(applicationRequest, Application.class);
        JobOffre jobOffre = offreRepository.findById(applicationRequest.getJob_offer_id()).orElseThrow();
        application.setJobOffer(jobOffre);
        Application savedApplication = applicationRepository.save(application);
        return modelMapper.map(savedApplication, ApplicationRequest.class);
    }

    @Override
    public ApplicationRequest updateApplication(ApplicationRequest applicationRequest) {
        return null;
    }

    @Override
    public ApplicationResponse getApplicationById(Long id) {
        Optional<Application> optionalApplication = applicationRepository.findById(id);
        return optionalApplication.map(application -> modelMapper.map(application, ApplicationResponse.class)).orElseThrow();
    }

    @Override
    public List<ApplicationResponse> getAllApplications() {
        List<Application> applicationList = applicationRepository.findAll();
        return applicationList.stream().map(application -> modelMapper.map(application, ApplicationResponse.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }
}

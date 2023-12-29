package com.joboffer.JobOffer;

import com.joboffer.Agent.Agent;
import com.joboffer.Agent.AgentRepository;
import com.joboffer.Company.Company;
import com.joboffer.Company.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobOffreServiceImp implements JobOffreService{
    private final JobOffreRepository jobOffreRepository;
    private final ModelMapper modelMapper;
    private final AgentRepository agentRepository;
    private final CompanyRepository companyRepository;
    @Override
    public JobOffreRequest createJobOffer(JobOffreRequest jobOffreRequest) {
        JobOffre jobOffre = modelMapper.map(jobOffreRequest, JobOffre.class);
        Agent agent = agentRepository.findById(jobOffreRequest.getAgent_id()).orElseThrow();
        Company company = companyRepository.findById(jobOffreRequest.getCompany_id()).orElseThrow();
        jobOffre.setCompany(company);
        jobOffre.setAgent(agent);
        JobOffre savedOffre = jobOffreRepository.save(jobOffre);
        return modelMapper.map(savedOffre, JobOffreRequest.class);
    }

    @Override
    public JobOffreRequest updateJobOffer(JobOffreRequest jobOffreRequest) {
        return null;
    }

    @Override
    public JobOffreResponse getOfferById(Long id) {
        Optional<JobOffre> optionalJobOffre = jobOffreRepository.findById(id);
        return optionalJobOffre.map(jobOffre -> modelMapper.map(jobOffre, JobOffreResponse.class)).orElseThrow();
    }

    @Override
    public List<JobOffreResponse> getAllOffers() {
        List<JobOffre> list = jobOffreRepository.findAll();
        return list.stream().map(jobOffre -> modelMapper.map(jobOffre, JobOffreResponse.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteOffer(Long id) {
        jobOffreRepository.deleteById(id);
    }
}

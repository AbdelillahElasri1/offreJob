package com.joboffer.Recruiter;

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
public class RecruiterServiceImp implements RecruiterService{
    private final ModelMapper modelMapper;
    private final RecruiterRepository recruiterRepository;
    private final CompanyRepository companyRepository;


    @Override
    public RecruiterRequest createRecruiter(RecruiterRequest recruiterRequest) {
        Recruiter recruiter = modelMapper.map(recruiterRequest, Recruiter.class);
        Company company = companyRepository.findById(recruiterRequest.getCompany_id()).orElseThrow();
        recruiter.setCompany(company);
        Recruiter savedRecruiter = recruiterRepository.save(recruiter);
        return modelMapper.map(savedRecruiter, RecruiterRequest.class);
    }

    @Override
    public RecruiterRequest updateRecruiter(RecruiterRequest recruiterRequest) {
        return null;
    }

    @Override
    public RecruiterResponse getRecruiterById(Long id) {
        Optional<Recruiter> optionalRecruiter = recruiterRepository.findById(id);
        return optionalRecruiter.map(recruiter -> modelMapper.map(recruiter, RecruiterResponse.class)).orElseThrow();
    }

    @Override
    public List<RecruiterResponse> getAllRecruiter() {
        List<Recruiter> list = recruiterRepository.findAll();
        return list.stream().map(recruiter -> modelMapper.map(recruiter, RecruiterResponse.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteRecruiter(Long id) {
        recruiterRepository.deleteById(id);
    }
}

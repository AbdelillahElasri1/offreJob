package com.joboffer.Company;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyServiceImp implements CompanyService{
    private final ModelMapper modelMapper;
    private final CompanyRepository companyRepository;
    @Override
    public CompanyRequest createCompany(CompanyRequest companyRequest) {
        Company company = modelMapper.map(companyRequest , Company.class);
        Company savedCompany = companyRepository.save(company);
        return modelMapper.map(savedCompany, CompanyRequest.class);
    }

    @Override
    public CompanyRequest updateCompany(CompanyRequest companyRequest) {
        return null;
    }

    @Override
    public List<CompanyResponse> findAllCompanies() {
        List<Company> list = companyRepository.findAll();
        return list.stream().map(company -> modelMapper.map(company, CompanyResponse.class)).collect(Collectors.toList());
    }

    @Override
    public CompanyResponse findCompanyById(Long id) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        return optionalCompany.map(company -> modelMapper.map(company, CompanyResponse.class)).orElseThrow();
    }

    @Override
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }
}

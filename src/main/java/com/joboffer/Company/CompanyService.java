package com.joboffer.Company;

import java.util.List;

public interface CompanyService {
    CompanyRequest createCompany(CompanyRequest companyRequest);
    CompanyRequest updateCompany(CompanyRequest companyRequest);
    List<CompanyResponse> findAllCompanies();
    CompanyResponse findCompanyById(Long id);
    void deleteCompany(Long id);

}

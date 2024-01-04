package com.joboffer.Company;

import java.io.IOException;
import java.util.List;

public interface CompanyService {
    CompanyRequest createCompany(CompanyRequest companyRequest) throws IOException;
    CompanyRequest updateCompany(CompanyRequest companyRequest);
    List<CompanyResponse> findAllCompanies();
    CompanyResponse findCompanyById(Long id);
    void deleteCompany(Long id);

}

package com.joboffer.Company;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/company")
public class CompanyController {
    private final CompanyService companyService;
    @PostMapping
    public ResponseEntity<CompanyRequest> createCompany(@RequestBody CompanyRequest companyRequest) throws IOException {
        CompanyRequest company = companyService.createCompany(companyRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(company);
    }
    @GetMapping
    public ResponseEntity<List<CompanyResponse>> findAllCompanies(){
        List<CompanyResponse> list = companyService.findAllCompanies();
        return ResponseEntity.ok(list);
    }
    @GetMapping("{id}")
    public ResponseEntity<CompanyResponse> findCompanyById(@PathVariable Long id){
        CompanyResponse response = companyService.findCompanyById(id);
        if (response != null){
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        companyService.deleteCompany(id);
        return ResponseEntity.ok("Company deleted with success");
    }
}

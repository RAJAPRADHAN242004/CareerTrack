package com.careertrack.controller;

import com.careertrack.dto.CompanyRequest;
import com.careertrack.entity.Company;
import com.careertrack.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CompanyController {
    @Autowired
    private final CompanyService companyService;
    @PostMapping("/api/admin/companies")
    public String addCompany(@RequestBody CompanyRequest companyRequest){
        return companyService.addCompany(companyRequest);
    }

    @GetMapping("/api/companies")
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }
}

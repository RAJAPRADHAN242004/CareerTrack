package com.careertrack.service;

import com.careertrack.dto.CompanyRequest;
import com.careertrack.entity.Company;
import com.careertrack.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    @Autowired
   private final CompanyRepository companyRepository;

   public String addCompany(CompanyRequest companyRequest){
       Company company=new Company();
       company.setName(companyRequest.getName());
       company.setWebsite(companyRequest.getWebsite());
       company.setLocation(companyRequest.getLocation());
       companyRepository.save(company);

       return "Company added successfully";
   }

   public List<Company> getAllCompanies(){
       return companyRepository.findAll();
   }
}

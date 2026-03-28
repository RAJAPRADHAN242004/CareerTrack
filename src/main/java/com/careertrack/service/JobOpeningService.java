package com.careertrack.service;

import com.careertrack.dto.JobOpeningRequest;
import com.careertrack.entity.Company;
import com.careertrack.entity.JobOpening;
import com.careertrack.repository.CompanyRepository;
import com.careertrack.repository.JobOpeningRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobOpeningService {
    @Autowired
    private final JobOpeningRepository jobOpeningRepository;
    @Autowired
    private final CompanyRepository companyRepository;

    public String addJob(JobOpeningRequest request) {
        Company company = companyRepository.findById(request.getCompanyId())
                .orElseThrow(() -> new RuntimeException("Company not found"));

        JobOpening job = new JobOpening();
        job.setTitle(request.getTitle());
        job.setDescription(request.getDescription());
        job.setJobType(request.getJobType());
        job.setLocation(request.getLocation());
        job.setSalary(request.getSalary());
        job.setDeadline(request.getDeadline());
        job.setCompany(company);

        jobOpeningRepository.save(job);

        return "Job opening added successfully";
    }

    public List<JobOpening> getAllJobs() {
        return jobOpeningRepository.findAll();
    }
    public JobOpening getJobById(Long id) {
        return jobOpeningRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found"));
    }
}

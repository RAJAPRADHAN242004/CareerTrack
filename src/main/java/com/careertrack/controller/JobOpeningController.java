package com.careertrack.controller;

import com.careertrack.dto.JobOpeningRequest;
import com.careertrack.entity.JobOpening;
import com.careertrack.service.JobOpeningService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class JobOpeningController {
    @Autowired
    private final JobOpeningService jobOpeningService;

    @PostMapping("/api/admin/jobs")
    public String addJob(@RequestBody JobOpeningRequest request) {
        return jobOpeningService.addJob(request);
    }

    @GetMapping("/api/jobs")
    public List<JobOpening> getAllJobs() {
        return jobOpeningService.getAllJobs();
    }

    @GetMapping("/api/jobs/{id}")
    public JobOpening getJobById(@PathVariable Long id) {
        return jobOpeningService.getJobById(id);
    }
}

package com.careertrack.controller;

import com.careertrack.dto.ApplicationRequest;
import com.careertrack.entity.Application;
import com.careertrack.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class ApplicationController {
    @Autowired
    private final ApplicationService applicationService;

    @PostMapping("/applications")
    public String apply(@RequestBody ApplicationRequest request,
                        Authentication authentication) {

        String email = authentication.getName();

        return applicationService.apply(request, email);
    }

    @GetMapping("/applications")
    public List<Application> getMyApplications(Authentication authentication) {

        String email = authentication.getName();

        return applicationService.getMyApplications(email);
    }

    @PatchMapping("/applications/{id}/status")
    public String updateStatus(@PathVariable Long id,
                               @RequestParam String status) {
        return applicationService.updateStatus(id, status);
    }

    @DeleteMapping("/applications/{id}")
    public String delete(@PathVariable Long id) {
        return applicationService.deleteApplication(id);
    }



}

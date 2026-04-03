package com.careertrack.controller;

import com.careertrack.dto.DashboardResponse;
import com.careertrack.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping
    public DashboardResponse getDashboard(Authentication authentication) {

        String email = authentication.getName();

        return dashboardService.getDashboard(email);
    }
}
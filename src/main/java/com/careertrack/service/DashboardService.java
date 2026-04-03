package com.careertrack.service;

import com.careertrack.dto.DashboardResponse;
import com.careertrack.entity.User;
import com.careertrack.repository.ApplicationRepository;
import com.careertrack.repository.InterviewRepository;
import com.careertrack.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final UserRepository userRepository;
    private final ApplicationRepository applicationRepository;
    private final InterviewRepository interviewRepository;

    public DashboardResponse getDashboard(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        long totalApplications = applicationRepository.countByUser(user);
        long totalInterviews = interviewRepository.countByApplication_User_Email(email);
        long pendingApplications = applicationRepository.countByUserAndStatus(user, "APPLIED");
        long selectedApplications = applicationRepository.countByUserAndStatus(user, "SELECTED");
        long rejectedApplications = applicationRepository.countByUserAndStatus(user, "REJECTED");

        return new DashboardResponse(
                totalApplications,
                totalInterviews,
                pendingApplications,
                selectedApplications,
                rejectedApplications
        );
    }
}
package com.careertrack.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DashboardResponse {
    private long totalApplications;
    private long totalInterviews;
    private long pendingApplications;
    private long selectedApplications;
    private long rejectedApplications;
}

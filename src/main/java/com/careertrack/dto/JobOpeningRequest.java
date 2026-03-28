package com.careertrack.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class JobOpeningRequest {
    private String title;
    private String description;
    private String jobType;
    private String location;
    private Double salary;
    private LocalDate deadline;
    private Long companyId;
}

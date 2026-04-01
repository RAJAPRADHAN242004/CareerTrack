package com.careertrack.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InterviewRequest {

    private Long applicationId;
    private Integer roundNo;
    private String roundType;
    private LocalDateTime scheduledAt;
    private String mode;
    private String meetingLink;
}
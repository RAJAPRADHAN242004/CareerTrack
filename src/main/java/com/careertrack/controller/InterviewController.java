package com.careertrack.controller;

import com.careertrack.dto.InterviewRequest;
import com.careertrack.entity.Interview;
import com.careertrack.service.InterviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student/interviews")
@RequiredArgsConstructor
public class InterviewController {

    private final InterviewService interviewService;

    @PostMapping
    public String scheduleInterview(@RequestBody InterviewRequest request) {
        return interviewService.scheduleInterview(request);
    }

    @GetMapping
    public List<Interview> getAllInterviews() {
        return interviewService.getAllInterviews();
    }

    @GetMapping("/upcoming")
    public List<Interview> getUpcomingInterviews() {
        return interviewService.getUpcomingInterviews();
    }
}
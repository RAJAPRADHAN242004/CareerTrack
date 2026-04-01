package com.careertrack.service;

import com.careertrack.dto.InterviewRequest;
import com.careertrack.entity.Application;
import com.careertrack.entity.Interview;
import com.careertrack.repository.ApplicationRepository;
import com.careertrack.repository.InterviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InterviewService {

    private final InterviewRepository interviewRepository;
    private final ApplicationRepository applicationRepository;

    public String scheduleInterview(InterviewRequest request) {

        Application application = applicationRepository.findById(request.getApplicationId())
                .orElseThrow(() -> new RuntimeException("Application not found"));

        Interview interview = new Interview();
        interview.setApplication(application);
        interview.setRoundNo(request.getRoundNo());
        interview.setRoundType(request.getRoundType());
        interview.setScheduledAt(request.getScheduledAt());
        interview.setMode(request.getMode());
        interview.setMeetingLink(request.getMeetingLink());
        interview.setStatus("SCHEDULED");

        interviewRepository.save(interview);

        return "Interview scheduled successfully";
    }

    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }

    public List<Interview> getUpcomingInterviews() {
        return interviewRepository.findByScheduledAtAfter(LocalDateTime.now());
    }
}
package com.careertrack.scheduler;

import com.careertrack.entity.Interview;
import com.careertrack.repository.InterviewRepository;
import com.careertrack.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InterviewReminderScheduler {

    private final InterviewRepository interviewRepository;
    private final EmailService emailService;

    @Scheduled(fixedRate = 60000) // every 1 minute
    public void sendInterviewReminders() {

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextHour = now.plusHours(1);

        List<Interview> interviews = interviewRepository.findAll();

        for (Interview interview : interviews) {

            if (interview.getScheduledAt() != null &&
                    interview.getScheduledAt().isAfter(now) &&
                    interview.getScheduledAt().isBefore(nextHour)) {

                String studentEmail = interview.getApplication().getUser().getEmail();

                String subject = "Interview Reminder - CareerTrack";
                String body = "Hello,\n\nYou have an upcoming interview.\n\n"
                        + "Round: " + interview.getRoundType() + "\n"
                        + "Time: " + interview.getScheduledAt() + "\n"
                        + "Mode: " + interview.getMode() + "\n"
                        + "Meeting Link: " + interview.getMeetingLink() + "\n\n"
                        + "Best of luck!\nCareerTrack Team";

                emailService.sendEmail(studentEmail, subject, body);
            }
        }
    }
}
package com.careertrack.service;

import com.careertrack.dto.ApplicationRequest;
import com.careertrack.entity.Application;
import com.careertrack.entity.JobOpening;
import com.careertrack.entity.User;
import com.careertrack.repository.ApplicationRepository;
import com.careertrack.repository.JobOpeningRepository;
import com.careertrack.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationService {
    @Autowired
    private final ApplicationRepository applicationRepository;
    @Autowired
    private final JobOpeningRepository jobOpeningRepository;
    @Autowired
    private final UserRepository userRepository;


    public String apply(ApplicationRequest request,String userEmail){

          User user=userRepository.findByEmail(userEmail)
                  .orElseThrow(()->new RuntimeException("User not found"));

        JobOpening job = jobOpeningRepository.findById(request.getJobId())
                .orElseThrow(() -> new RuntimeException("Job not found"));

        Application app = new Application();
        app.setUser(user);
        app.setJobOpening(job);
        app.setStatus("APPLIED");
        app.setAppliedAt(LocalDateTime.now());
        app.setResumeUrl(request.getResumeUrl());
        app.setNotes(request.getNotes());

        applicationRepository.save(app);

        return "Application submitted successfully";
    }

    public List<Application> getMyApplications(String userEmail) {

        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return applicationRepository.findByUser(user);
    }

    public String updateStatus(Long id, String status) {

        Application app = applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));

        app.setStatus(status);
        applicationRepository.save(app);

        return "Status updated";
    }

    public String deleteApplication(Long id) {
        applicationRepository.deleteById(id);
        return "Application deleted";
    }

}

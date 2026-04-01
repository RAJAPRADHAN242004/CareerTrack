package com.careertrack.controller;

import com.careertrack.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class TestEmailController {

    private final EmailService emailService;

    @GetMapping("/email")
    public String testEmail(@RequestParam String to) {

        emailService.sendEmail(
                to,
                "Test Email from CareerTrack",
                "This is a test email from your Spring Boot project."
        );

        return "Test email sent successfully";
    }
}
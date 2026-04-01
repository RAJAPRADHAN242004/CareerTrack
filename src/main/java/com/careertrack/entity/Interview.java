package com.careertrack.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "interviews")
@Data
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer roundNo;
    private String roundType;
    private LocalDateTime scheduledAt;
    private String mode;
    private String meetingLink;
    private String status;

    @ManyToOne
    @JoinColumn(name = "application_id")
    private Application application;
}
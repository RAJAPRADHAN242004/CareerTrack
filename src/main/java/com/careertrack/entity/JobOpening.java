package com.careertrack.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Entity
@Table(name = "job_openings")
@Data
public class JobOpening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String jobType;
    private String location;
    private Double salary;
    private LocalDate deadline;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

}

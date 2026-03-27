package com.careertrack.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="companies")
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String website;
    private String location;
}

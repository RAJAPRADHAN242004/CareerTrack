package com.careertrack.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class RegisterRequest {
    private String fullName;
    private String email;

    private String password;


}

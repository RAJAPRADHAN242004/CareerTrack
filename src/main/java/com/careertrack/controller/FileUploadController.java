package com.careertrack.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/public/files")
public class FileUploadController {

    @Value("${file.upload-dir}")
    private String uploadDir;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadResume(@RequestParam("file") MultipartFile file) {

        System.out.println(" FILE UPLOAD API HIT");

        try {
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("File is empty");
            }

            String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
            String fileExtension = "";

            int dotIndex = originalFilename.lastIndexOf(".");
            if (dotIndex > 0) {
                fileExtension = originalFilename.substring(dotIndex);
            }

            String uniqueFileName = UUID.randomUUID() + fileExtension;

            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            Path filePath = uploadPath.resolve(uniqueFileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            return ResponseEntity.ok("File uploaded successfully: " + uniqueFileName);

        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("File upload failed");
        }
    }
}
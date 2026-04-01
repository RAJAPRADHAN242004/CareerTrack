package com.careertrack.repository;

import com.careertrack.entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface InterviewRepository extends JpaRepository<Interview, Long> {

    List<Interview> findByScheduledAtAfter(LocalDateTime time);
}
package com.careertrack.repository;

import com.careertrack.entity.Application;
import com.careertrack.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ApplicationRepository extends JpaRepository<Application,Long> {
    List<Application> findByUser(User user);

    long countByUser(User user);

    long countByUserAndStatus(User user, String status);
}

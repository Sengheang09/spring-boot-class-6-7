package com.example.springsecurity67.repository;

import com.example.springsecurity67.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}

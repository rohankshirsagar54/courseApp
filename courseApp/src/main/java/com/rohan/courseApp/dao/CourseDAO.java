package com.rohan.courseApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rohan.courseApp.entity.Course;

@Repository
public interface CourseDAO extends JpaRepository<Course, Long> {

}

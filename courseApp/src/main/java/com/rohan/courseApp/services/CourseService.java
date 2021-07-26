package com.rohan.courseApp.services;

import java.util.List;

import com.rohan.courseApp.entity.Course;

public interface CourseService {
	
	public List<Course> getCourses();
	
	public Course getCourse(long courseId);
	
	public Course addCourse(Course course);
	
	public Course updateCourse(long courseId,Course course);
	
	public void deleteCourse(long courseId);
	

}

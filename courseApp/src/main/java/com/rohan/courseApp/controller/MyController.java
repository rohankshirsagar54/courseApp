package com.rohan.courseApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rohan.courseApp.entity.Course;
import com.rohan.courseApp.services.CourseService;

@CrossOrigin
@RestController
public class MyController {
	
	@Autowired
	private CourseService courseService;
	
	
	// get the courses
	@GetMapping("/courses")
	public List<Course> getCourses(){
		
		
		return this.courseService.getCourses();
	}
	
	//get the course by Id
	
	@GetMapping("/course/{courseId}")
	public Course getCourse(@PathVariable("courseId") String courseId) {
		
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	//adding new id
	
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		
		return this.courseService.addCourse(course);
	}
	
	
	//updating the course
	@PutMapping(path="/course/{courseId}",consumes ="application/json")
	public Course updateCourse(@PathVariable("courseId") String courseId, @RequestBody Course course) {
		
		return this.courseService.updateCourse(Long.parseLong(courseId),course);
	}
	
	
	//deleting the courses
	@DeleteMapping("/course/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable("courseId") String courseId){
		try {
		this.courseService.deleteCourse(Long.parseLong(courseId));
		return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}

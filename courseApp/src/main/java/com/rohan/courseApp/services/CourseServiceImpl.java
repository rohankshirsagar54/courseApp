package com.rohan.courseApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohan.courseApp.dao.CourseDAO;
import com.rohan.courseApp.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	//List<Course> list;
	@Autowired
	private CourseDAO courseDao;
	
	public CourseServiceImpl() {
		//list=new ArrayList<>();
		
		//list.add(new Course(101,"Java","Core Java"));
		//list.add(new Course(102,"J2EE","Advanced Java"));
		//list.add(new Course(103,"Spring","Spring Java"));
		//list.add(new Course(104,"SpringBoot","SpringBoot Java"));
	}

	@Override
	public List<Course> getCourses() {
		
		return courseDao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {
		
		/*Course c=null;
		
		for(Course course:list) {
			if(course.getId()==courseId) {
				c=course;
				break;
			}
		}*/
		
		return courseDao.findById(courseId).get();
	}

	@Override
	public Course addCourse(Course course) {
		
		//list.add(course);
		courseDao.save(course);
		
		return course;
	}

	@Override
	public Course updateCourse(long courseId,Course course) {
		
		/*list.forEach(e ->{
			if(e.getId()==course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
		});*/
		
		//courseDao.save(course);
		
		Course results=courseDao.getOne(courseId);
		
		results.setId(course.getId());
		results.setTitle(course.getTitle());
		results.setDescription(course.getDescription());
		
		 Course updatedCourse=courseDao.save(results);
		
		
		return updatedCourse;
	}

	@Override
	public void deleteCourse(long courseId) {
		
		//list=this.list.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());
		
		Course entity=courseDao.getOne(courseId);
		courseDao.delete(entity);
	}

}

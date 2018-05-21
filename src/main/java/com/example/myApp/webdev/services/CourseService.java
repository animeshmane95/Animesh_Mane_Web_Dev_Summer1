package com.example.myApp.webdev.services;

import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myApp.webdev.models.Course;
import com.example.myApp.webdev.models.User;
import com.example.myApp.webdev.repositories.CourseRepository;

@RestController
@CrossOrigin("*")
public class CourseService {
	@Autowired
	CourseRepository courseRepository;
	HttpSession session1;
	
	@GetMapping("/api/course/{id}")
	public Optional<Course> findCourseById(@PathVariable("id") int id) {
		return courseRepository.findById(id);
	}
	
	@GetMapping("/api/course")
	public Iterable<Course> findAllCourses() {
		return courseRepository.findAll();
	}
	
	@PostMapping("/api/course")
	public Course createCourse(@RequestBody Course course) {
		course.setCreated(new Date());
		return courseRepository.save(course);
	}
	
	@DeleteMapping("/api/course/{courseId}")
	public void delete(@PathVariable("courseId") int id) {
		System.out.println("inside delete course");
		courseRepository.deleteById(id);
	
	
		
	}
}

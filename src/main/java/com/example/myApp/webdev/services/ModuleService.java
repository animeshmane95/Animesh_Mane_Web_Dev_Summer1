package com.example.myApp.webdev.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myApp.webdev.models.Course;
import com.example.myApp.webdev.models.Module;
import com.example.myApp.webdev.repositories.CourseRepository;
import com.example.myApp.webdev.repositories.ModuleRepository;

@RestController
@CrossOrigin("*")
public class ModuleService {
	
	@Autowired
	ModuleRepository moduleRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	CourseService courseService = new CourseService();
	
	HttpSession session1;
	
	@GetMapping("/api/module")
	public Iterable<Module> findAllModules() {
		return moduleRepository.findAll();
	}
	
	@PostMapping("/api/course/{cid}/module")
	public Module createModule(@RequestBody Module module, @PathVariable("cid") int id) {
		Module newModule =new Module();
		System.out.println(newModule);
		Optional<Course> course = courseRepository.findById(id);
		module.setCourse(course.get());
		return moduleRepository.save(module);
	}
	
	@GetMapping("/api/course/{cid}/module")
	public List<Module> findAllModulesForCourse(@PathVariable("cid") int id) {
		return moduleRepository.findAllModulesForCourse(id);
	}
}

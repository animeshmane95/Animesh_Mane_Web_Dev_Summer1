package com.example.myApp.webdev.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myApp.webdev.models.Lesson;
import com.example.myApp.webdev.models.Module;
import com.example.myApp.webdev.repositories.LessonRepository;
import com.example.myApp.webdev.repositories.ModuleRepository;

@RestController
@CrossOrigin("*")
public class LessonService {
	
	@Autowired
	LessonRepository lessonRepository;
	
	@Autowired
	ModuleRepository moduleRepository;
	
	@GetMapping("/api/course/{cid}/module/{mid}/lesson")
	public List<Lesson> findAllLessonsForModule(@PathVariable("mid") int id) {
		
		System.out.println(" inside find all lessoon ");
		return lessonRepository.findAllLessonsForModule(id);
	}
	
	@PostMapping("/api/course/{cid}/module/{mid}/lesson")
	public Lesson createLesson(@RequestBody Lesson lesson, @PathVariable("mid") int id) {
		Optional<Module> module = moduleRepository.findById(id);
		lesson.setModule(module.get());
		return lessonRepository.save(lesson);
	}
	
	@DeleteMapping("/api/course/{cid}/module/{mid}/lesson/{lessonId}")
	public void delete(@PathVariable("lessonId") int id) {
		System.out.println("Inside Delete Service");
		lessonRepository.deleteById(id);	
	}
}

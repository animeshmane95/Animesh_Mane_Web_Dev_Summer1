package com.example.myApp.webdev.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.myApp.webdev.models.Assignment;
import com.example.myApp.webdev.models.Course;
import com.example.myApp.webdev.models.Lesson;
import com.example.myApp.webdev.models.Widget;
import com.example.myApp.webdev.repositories.AssignmentRepository;
import com.example.myApp.webdev.repositories.WidgetRepository;

@RestController
@CrossOrigin(origins = "*")
public class AssignmentService {
	
	@Autowired
	AssignmentRepository assignmentRepository;
	
	@GetMapping("/api/assignment")
	public Iterable<Assignment> findAllAssignments() {
		return assignmentRepository.findAll();
	}
	
	@GetMapping("/api/assignment/{aid}")
	public Optional<Assignment> findCourseById(@PathVariable("aid") int id) {
		return assignmentRepository.findById(id);
	}
	
	@GetMapping("/api/topic/{tid}/assignment")
	public List<Widget> findAllAssignmentForTopic(@PathVariable("tid") int id) {
		
		//System.out.println(" inside find all lessoon ");
		return assignmentRepository.findAllAssignmentsForTopic(id);
	}
}

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

import com.example.myApp.webdev.models.Assignment;
import com.example.myApp.webdev.models.Course;
import com.example.myApp.webdev.models.Lesson;
import com.example.myApp.webdev.models.Module;
import com.example.myApp.webdev.models.Topic;
import com.example.myApp.webdev.models.Widget;
import com.example.myApp.webdev.repositories.AssignmentRepository;
import com.example.myApp.webdev.repositories.TopicRepository;
import com.example.myApp.webdev.repositories.WidgetRepository;

@RestController
@CrossOrigin(origins = "*")
public class AssignmentService {
	
	@Autowired
	AssignmentRepository assignmentRepository;
	
	@Autowired
	TopicRepository topicRepository;
	
	@GetMapping("/api/assignment")
	public Iterable<Assignment> findAllAssignments() {
		return assignmentRepository.findAll();
	}
	
	@GetMapping("/api/assignment/{aid}")
	public Optional<Assignment> findCourseById(@PathVariable("aid") int id) {
		return assignmentRepository.findById(id);
	}
	
	@GetMapping("/api/topic/{tid}/assignment")
	public List<Assignment> findAllAssignmentForTopic(@PathVariable("tid") int id) {
		
		//System.out.println(" inside find all lessoon ");
		List<Assignment> A = assignmentRepository.findAllAssignmentsForTopic(id);
		return A;
	}
	
	@PostMapping("/api/topic/{tid}/assignment")
	public Assignment createAssignment(@RequestBody Assignment assignment, @PathVariable("tid") int id) {
		Optional<Topic> topic = topicRepository.findById(id);
		assignment.setTopic(topic.get());
		return assignmentRepository.save(assignment);
	}
	

	@DeleteMapping("/api/delete/assignment/{aid}")
	public void deleteAssignment(@PathVariable("aid") int widgetId) {
		assignmentRepository.deleteById(widgetId);	
	}	
	
}

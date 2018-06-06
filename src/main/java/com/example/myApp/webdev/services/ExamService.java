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

import com.example.myApp.webdev.repositories.ExamRepository;
import com.example.myApp.webdev.repositories.TopicRepository;
import com.example.myApp.webdev.models.Assignment;
import com.example.myApp.webdev.models.Exam;
import com.example.myApp.webdev.models.Question;
import com.example.myApp.webdev.models.Topic;
@RestController
@CrossOrigin(origins = "*")
public class ExamService {
	
	@Autowired
	ExamRepository examRepository;
	
	@Autowired
	TopicRepository topicRepository;
	
	@GetMapping("/api/topic/{tid}/exam")
	public List<Exam> findAllExamsForTopic(@PathVariable("tid") int id) {
		
		//System.out.println(" inside find all lessoon ");
		List<Exam> A = examRepository.findAllExamsForTopic(id);
		return A;
	}
	
	
	@PostMapping("/api/topic/{tid}/exam")
	public Exam creatExam(@RequestBody Exam exam, @PathVariable("tid") int id) {
		Optional<Topic> topic = topicRepository.findById(id);
		exam.setTopic(topic.get());
		return examRepository.save(exam);
	}
	

	@DeleteMapping("/api/delete/exam/{eid}")
	public void deleteAssignment(@PathVariable("eid") int widgetId) {
		examRepository.deleteById(widgetId);	
	}	
	
	@GetMapping("/api/exam/{examId}/question")
	public List<Question> findAllQuestionsForExam(@PathVariable("examId") int examId) {
		Optional<Exam> optionalExam = examRepository.findById(examId);
		if(optionalExam.isPresent()) {
			Exam exam = optionalExam.get();
			List<Question> questions = exam.getQuestions();
			int count = questions.size();
			return questions;
		}
		return null;
	}

}

package com.example.myApp.webdev.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myApp.webdev.models.EssayQuestion;
import com.example.myApp.webdev.models.Exam;
import com.example.myApp.webdev.models.Question;
import com.example.myApp.webdev.repositories.EssayQuestionRepository;
import com.example.myApp.webdev.repositories.ExamRepository;

@RestController
@CrossOrigin(origins = "*")
public class QuestionService {
	@Autowired
	EssayQuestionRepository essayRepository;
	
	@Autowired
	ExamRepository examRepository;
	
	@PostMapping("/api/exam/{eid}/essay")
	public EssayQuestion createEssayQuestion(@RequestBody EssayQuestion question, @PathVariable("eid") int id) {
		Optional<Exam> exam = examRepository.findById(id);
		question.setExam(exam.get());
		return essayRepository.save(question);
	}
	
//	@GetMapping("/api/exam/{eid}/question")
//	public List<Question> findAllQuestionsForExam(@PathVariable("eid") int id) {
//		List<Question> A = examRepository.findAllQuestionsForExam(id);
//		return A;
//	}

}

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

import com.example.myApp.webdev.models.BlanksQuestion;
import com.example.myApp.webdev.models.EssayQuestion;
import com.example.myApp.webdev.models.Exam;
import com.example.myApp.webdev.models.Question;
import com.example.myApp.webdev.models.TrueFalseQuestion;
import com.example.myApp.webdev.repositories.BlankQuestionRepository;
import com.example.myApp.webdev.repositories.EssayQuestionRepository;
import com.example.myApp.webdev.repositories.ExamRepository;
import com.example.myApp.webdev.repositories.TrueFalseQuestionRespository;

@RestController
@CrossOrigin(origins = "*")
public class QuestionService {
	@Autowired
	EssayQuestionRepository essayRepository;
	
	@Autowired
	TrueFalseQuestionRespository trueFalseQuestionRepository;
	
	@Autowired
	ExamRepository examRepository;
	
	@Autowired
	BlankQuestionRepository blankQuestionRepository;
	
	@PostMapping("/api/exam/{eid}/essay")
	public EssayQuestion createEssayQuestion(@RequestBody EssayQuestion question, @PathVariable("eid") int id) {
		Optional<Exam> exam = examRepository.findById(id);
		question.setExam(exam.get());
		return essayRepository.save(question);
	}
	
	@PostMapping("/api/exam/{eid}/truefalse")
	public TrueFalseQuestion createTrueFalseQuestion(@RequestBody TrueFalseQuestion question, @PathVariable("eid") int id) {
		Optional<Exam> exam = examRepository.findById(id);
		question.setExam(exam.get());
		return trueFalseQuestionRepository.save(question);
	}
	
	@PostMapping("/api/exam/{eid}/blanks")
	public BlanksQuestion createBlankQuestion(@RequestBody BlanksQuestion question, @PathVariable("eid") int id) {
		Optional<Exam> exam = examRepository.findById(id);
		question.setExam(exam.get());
		return blankQuestionRepository.save(question);
	}
	


}

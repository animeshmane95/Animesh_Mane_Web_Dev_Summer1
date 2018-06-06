package com.example.myApp.webdev.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.myApp.webdev.models.Exam;
import com.example.myApp.webdev.models.Question;
import com.example.myApp.webdev.models.Widget;


public interface ExamRepository extends CrudRepository<Exam, Integer>{
	@Query(value = "Select * from widget where topic_id =?1 AND dtype = 'Exam'", nativeQuery = true)
	public List<Exam>findAllExamsForTopic(@Param("topic_id") int topicid);
	
	@Query(value = "Select * from question where exam_id =?1", nativeQuery = true)
	public List<Question>findAllQuestionsForExam(@Param("exam_id") int examid);
}
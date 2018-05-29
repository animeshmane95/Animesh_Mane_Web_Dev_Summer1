package com.example.myApp.webdev.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.myApp.webdev.models.Topic;
import com.example.myApp.webdev.models.Widget;



public interface TopicRepository extends CrudRepository<Topic,Integer> {
	
	@Query(value = "Select * from topic where lesson_id =?1", nativeQuery = true)
	public List<Topic>findAllTopicsForLesson(@Param("lessonid") int lessonid);

}

package com.example.myApp.webdev.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.myApp.webdev.models.Lesson;
import com.example.myApp.webdev.models.Module;

public interface LessonRepository extends CrudRepository<Lesson,Integer> {
	@Query(value = "Select * from lesson where module_id =?1", nativeQuery = true)
	public List<Lesson>findAllLessonsForModule(@Param("moduleid") int moduleid);
	
}
